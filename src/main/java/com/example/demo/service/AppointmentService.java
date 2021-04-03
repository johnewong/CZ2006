package com.example.demo.service;

import com.example.demo.dao.AppointmentDAO;
import com.example.demo.pojo.*;
import com.example.demo.utility.StatusType;
import com.example.demo.viewmodel.AppointmentInfo;
import com.example.demo.viewmodel.AvailableSlot;
import com.example.demo.viewmodel.VetSlot;
import com.example.demo.viewmodel.VeterSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AppointmentService {
    @Autowired
    AppointmentDAO appointmentDAO;
    @Autowired
    VetService vetService;
    @Autowired
    VeterService veterService;
    @Autowired
    AccountService accountService;
    @Autowired
    TreatmentService treatmentService;
    @Autowired
    EmailService emailService;

    //public void add(Appointment appointment){ appointmentDAO.save(appointment); }

    /**
     * Method to get appointment by its appointmentID
     *
     * @param appointmentid
     * @return appointment
     */
    public Appointment getByAppointmentID(Integer appointmentid) {
        return appointmentDAO.findByAppointmentIDAndIsDeletedFalse(appointmentid);
    }

    /**
     * Method to get appointment by its appointment number
     *
     * @param appointmentnumber
     * @return
     */
    public Appointment getByAppointmentNumber(String appointmentnumber) {
        return appointmentDAO.findByAppointmentNumberAndIsDeletedFalse(appointmentnumber);
    }

    public List<Appointment> getByCustomerID(Integer customerid) {
        return appointmentDAO.findByCustomerIDAndIsDeletedFalse(customerid, Sort.by(Sort.Direction.DESC, "appointmentDate"));
    }

    /**
     * Method to list down appointment information
     * (Date, appointment start time and end time,
     * status, customer, veter and treatment)
     *
     * @param appointmentList
     * @return list of appointment information
     */

    public List<AppointmentInfo> prepareAppointmentInfo(List<Appointment> appointmentList) {
        List<AppointmentInfo> AppointInfoList = new ArrayList<>();
        for (Appointment aitem : appointmentList) {

            AppointmentInfo Info = new AppointmentInfo();
            Info.setAppointment(aitem);

            SimpleDateFormat localDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Info.setAppointmentDateFormat(localDateFormat.format(aitem.getAppointmentDate()));

            SimpleDateFormat localTimeFormat = new SimpleDateFormat("HH:mm");
            Info.setAppointmentStartTimeFormat(localTimeFormat.format(aitem.getAppointmentStartTime()));
            Info.setAppointmentEndTimeFormat(localTimeFormat.format(aitem.getAppointmentEndTime()));

            Info.setAppointmentStatusFormat(StatusType.getValue(aitem.getStatus()));

            User user = accountService.getByUserID(aitem.getCustomerID());
            Info.setCustomer(user);

            Veter veter = veterService.getByVeterID(aitem.getVeterID());
            veter.setScheduleList(null);
            Info.setVeter(veter);

            Treatment treatment = treatmentService.getByTreatmentID(aitem.getTreatmentID());
            Info.setTreatment(treatment);

            AppointInfoList.add(Info);
        }

        return AppointInfoList;
    }

    /**
     * Method to get all appointments by Vetid
     *
     * @param vetid
     * @return appointment list for specific vet
     */
    public List<AppointmentInfo> getByVetID(Integer vetid) {
        List<Appointment> appointmentList = appointmentDAO.findByVetIDAndIsDeletedFalse(vetid, Sort.by(Sort.Direction.DESC, "appointmentDate"));

        return prepareAppointmentInfo(appointmentList);
    }

    /**
     * Method to get future appointment by userid
     *
     * @param userid
     * @return list of future appointments
     */
    public List<AppointmentInfo> getByCustomerIDAndMoreThanNow(Integer userid) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        List<Appointment> appointmentList = appointmentDAO.findByCustomerIDAndMoreThanNowAndIsDeletedFalse(userid, date);

        return prepareAppointmentInfo(appointmentList);
    }

    public List<Appointment> getByVetIDAndVeterIDAndDate(Integer vetid, Integer veterid, Date date) {
        return appointmentDAO.findByVetIDAndAppointmentDateAndIsDeletedFalse(vetid, date, Sort.by(Sort.Direction.DESC, "appointmentStartTime"));
    }

    /**
     * Method to get appointments by vetid, veterid and
     * appointment date and time
     *
     * @param vetid
     * @param veterid
     * @param AppointDate
     * @param StartTime
     * @param EndTime
     * @return appointments
     */
    public List<Appointment> getByVetIDAndVeterIDAndPeriod(Integer vetid, Integer veterid, Date AppointDate, Date StartTime, Date EndTime) {
        return appointmentDAO.findByVetIDAndVeterIDAndPeriodAndIsDeletedFalse(vetid, veterid, AppointDate,StartTime, EndTime);

    }

    /**
     * Method to get appointments other than appointments
     * by vetid, veterid and appointment date and time
     *
     * @param vetid
     * @param veterid
     * @param AppointDate
     * @param StartTime
     * @param EndTime
     * @param AppointmentID
     * @return appointments
     */
    public List<Appointment> getByVetIDAndVeterIDAndPeriodAndNotInID(Integer vetid, Integer veterid, Date AppointDate, Date StartTime, Date EndTime, Integer AppointmentID) {
        return appointmentDAO.findByVetIDAndVeterIDAndPeriodAndIsDeletedFalseAndNotInID(vetid, veterid, AppointDate, StartTime, EndTime, AppointmentID);

    }

    /**
     * Method to cancel appointment by appointmentid
     *
     * @param appointmnetid
     * @return false if appointment not exist or already canceled or expired
     */
    public Boolean cancelAppointmentByID(Integer appointmnetid) {
        Date updatedDate = new Date();

        Appointment appointmentModel = getByAppointmentID(appointmnetid);

        if (appointmentModel == null) {
            return false;
        }

        if (appointmentModel.getStatus() == 2 || appointmentModel.getStatus() == 3) {
            return false;
        }

        appointmentModel.setStatus(2);
        appointmentModel.setUpdatedBy(appointmentModel.getCreatedBy());
        appointmentModel.setUpdatedDate(updatedDate);
        appointmentDAO.save(appointmentModel);

       /* User user = accountService.getByUserID(appointmentModel.getCustomerID());
        if(user != null){
            String subject = "AppName";
            String body = "Dear customer, \n\nYour appointment is cancelled. \nAppointment Number: " + appointmentModel.getAppointmentNumber();
            emailService.send(user.getEmailAddress(),subject,body);

        }*/

        return true;
    }

    /**
     * Method to cancel appointment by appointmentNumber
     *
     * @param appointmentNumber
     * @return false if appointment not exist or already canceled or expired
     */
    public Boolean cancelAppointmentByNumber(String appointmentNumber) {
        Date updatedDate = new Date();

        Appointment appointmentModel = getByAppointmentNumber(appointmentNumber);

        if (appointmentModel == null) {
            return false;
        }

        if (appointmentModel.getStatus() == 2 || appointmentModel.getStatus() == 3) {
            return false;
        }

        appointmentModel.setStatus(2);
        appointmentModel.setUpdatedBy(appointmentModel.getCreatedBy());
        appointmentModel.setUpdatedDate(updatedDate);
        appointmentDAO.save(appointmentModel);

        //   User user = accountService.getByUserID(appointmentModel.getCustomerID());
        //  if(user != null){
        //     String subject = "AppName";
        //     String body = "Dear customer, \n\nYour appointment is cancelled. \nAppointment Number: " + appointmentModel.getAppointmentNumber();
        //     emailService.send(user.getEmailAddress(),subject,body);

        //  }

        return true;
    }

    /**
     * Method to edit appointment
     *
     * @param appointment
     * @return true if edit successfully, false if not
     */
    public Boolean edit(Appointment appointment) {
        Date updatedDate = new Date();

        Appointment appointmentModel = getByAppointmentID(appointment.getAppointmentID());

        if (appointmentModel == null) {
            return false;
        }

        List<Appointment> list = getByVetIDAndVeterIDAndPeriodAndNotInID(appointment.getVetID(), appointment.getVeterID(), appointment.getAppointmentDate(), appointment.getAppointmentStartTime(), appointment.getAppointmentEndTime(), appointment.getAppointmentID());
        if (list.size() > 0) {
            return false;
        }

        appointmentModel.setAppointmentDate(appointment.getAppointmentDate());
        appointmentModel.setVeterID(appointment.getVeterID());

        appointmentModel.setAppointmentStartTime(appointment.getAppointmentStartTime());
        appointmentModel.setAppointmentEndTime(appointment.getAppointmentEndTime());
        appointmentModel.setUpdatedDate(updatedDate);
        appointmentModel.setUpdatedBy(appointment.getCreatedBy());
        appointmentDAO.save(appointmentModel);
        return true;
    }

    public List<VetSlot> getVetByLocationAndDateAndTreatment(Integer locationid, Integer treatmentid, Date date) {
        List<VetSlot> vetSlotList = new ArrayList<>();

        List<Vet> vetlist = vetService.getByLocationID(locationid);
        for (Vet vet : vetlist) {

            Set<VetTreatment> vt = vet.getVetTreatmentList();
            for(VetTreatment vtitem: vt){
                if(vtitem.getTreatmentID() == treatmentid){
                    List<VeterSlot> veterSlots = getAvailableSlotByVetIDAndTreatmentID(vet.getVetId(), treatmentid, date);

                    if (veterSlots.size() > 0) {

                        VetSlot vetSlot = new VetSlot();
                        vetSlot.setVet(vet);
                        vetSlot.setVeterSlot(veterSlots);
                        vetSlotList.add(vetSlot);
                    }
                    break;
                }
            }


        }
        return vetSlotList;
    }

    /**
     * Method to get available slot by vetid, treatmentid and date
     *
     * @param vetid
     * @param treatmentid
     * @param date
     * @return available veter slot
     */
    public List<VeterSlot> getAvailableSlotByVetIDAndTreatmentID(Integer vetid, Integer treatmentid, Date date) {

        Integer dateofweek = date.getDay();

        //  Integer dateofweek = date.getDay();
        Vet vetModel = vetService.getByVetID(vetid);
        Set<Veter> veterList = vetModel.getVeterList();
        Set<VetTreatment> vetTreatment = vetModel.getVetTreatmentList();

        float TreatmentDuration = 1;
        for (VetTreatment element : vetTreatment) {
            if (element.getTreatmentID() == treatmentid) {
                TreatmentDuration = element.getPerSeccionDuration();
                break;
            }
        }

        List<VeterSlot> veterSlots = new ArrayList<VeterSlot>();
        for (Veter veter : veterList) {

            if (veter.getLeaveStartDate() != null && veter.getLeaveEndDate() != null) {
                if (date.compareTo(veter.getLeaveStartDate()) == 0
                        || date.compareTo(veter.getLeaveEndDate()) == 0
                        || (date.compareTo(veter.getLeaveStartDate()) > 0
                        && date.compareTo(veter.getLeaveEndDate()) <= 0)) {
                    continue;
                }
            }


            VeterSlot veterSlot = new VeterSlot();
            veterSlot.setVeter(veter);

            Set<Schedule> scheduleList = veter.getScheduleList();
            Schedule scheduleModel = null;
            for (Schedule schedule : scheduleList) {
                if (schedule.getDayOfWeek() == dateofweek) {
                    scheduleModel = schedule;
                    break;
                }
            }
            if (scheduleModel != null) {

                long timediff = scheduleModel.getEndTime().getTime() - scheduleModel.getStartTime().getTime();
                long difference_In_Hours
                        = (timediff
                        / (1000 * 60 * 60))
                        % 24;

                float countSection = difference_In_Hours / TreatmentDuration;

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(scheduleModel.getStartTime());

                cal2.set(year,month,day);
                Date StartTime = cal2.getTime();
           //     Date StartTime = scheduleModel.getStartTime();
            //    StartTime.setYear(year);
            //    StartTime.setMonth(month);
            //    StartTime.setDate(day);

                List<AvailableSlot> slots = new ArrayList<AvailableSlot>();
                for (int i = 0; i < (int) countSection; i++) {

                    long t = StartTime.getTime();
                    long t1 = (long) TreatmentDuration * 60 * 60000;
                    long t2 = (long) (t + t1);
                    Date afterAdding = new Date(t2);

                    AvailableSlot slot = new AvailableSlot();
                    slot.setStartTime(StartTime);
                    slot.setEndTime(afterAdding);
                    slot.setAvailable(true);
                    slots.add(slot);
                    StartTime = afterAdding;
                }

                veterSlot.setAvailableSlots(slots);

            }
            veterSlots.add(veterSlot);
        }

        for (VeterSlot veterSlot : veterSlots) {
            if (veterSlot.getAvailableSlots() != null) {
                for (AvailableSlot ava : veterSlot.getAvailableSlots()) {
                    List<Appointment> list = getByVetIDAndVeterIDAndPeriod(vetid, veterSlot.getVeter().getVeterID(), null, ava.getStartTime(), ava.getEndTime());
                    if (list.size() > 0) {
                        ava.setAvailable(false);
                    }
                }
            }


        }

        return veterSlots;

    }

    /**
     * Method to add an appoinement
     *
     * @param appointment
     * @return true if added successfully, false if failed
     */
    public Appointment addAppointment(Appointment appointment) {

        List<Appointment> list = getByVetIDAndVeterIDAndPeriod(appointment.getVetID(), appointment.getVeterID(), null, appointment.getAppointmentStartTime(), appointment.getAppointmentEndTime());
        if (list.size() > 0) {
            return null;
        } else {

            Appointment appointmentModel = new Appointment();
            appointmentModel.setAppointmentNumber(findAppointmentNumber());
            appointmentModel.setStatus(appointment.getStatus());

            appointmentModel.setAppointmentEndTime(appointment.getAppointmentEndTime());
            appointmentModel.setAppointmentDate(appointment.getAppointmentDate());
            appointmentModel.setAppointmentStartTime(appointment.getAppointmentStartTime());
            appointmentModel.setVetID(appointment.getVetID());
            appointmentModel.setVeterID(appointment.getVeterID());
            appointmentModel.setVetID(appointment.getVetID());
            appointmentModel.setCustomerID(appointment.getCustomerID());
            appointmentModel.setCustomerName(appointment.getCustomerName());
            appointmentModel.setCreatedBy(appointment.getCreatedBy());
            appointmentModel.setCreatedDate(appointment.getCreatedDate());
            appointmentModel.setTreatmentID(appointment.getTreatmentID());

            return appointmentDAO.save(appointmentModel);
        }
    }

    public String findAppointmentNumber() {
        Appointment lastapp = appointmentDAO.findLastAppointment();
        String newNumber = "APPOINT00000001";
        if (lastapp != null) {
            Integer number = Integer.parseInt(lastapp.getAppointmentNumber().replace("APPOINT", ""));
            number = number + 1;
            newNumber = "APPOINT" + String.format("%08d", number);
        }
        return newNumber;
    }


}
