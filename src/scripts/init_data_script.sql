insert into user values('1', 'user01','user 01','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','2021-01-01','123@email.com','820000'
                       ,1,'G140022P','0','1',2,'2021-01-01',null,null,0);

insert into user values('2', 'admin01','admin 01','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','2021-01-01','1234@email.com','820000'
                       ,1,'G140022P','1','1',2,'2021-01-01',null,null,0);

insert into user values('3', 'user02','user 02','76431fac8a187241af8f3f37156deb94732f52fb45eb07ec4f462051bd82f183','2021-01-01','12345@email.com','820000'
                       ,1,'G140022P','0','1',2,'2021-01-01',null,null,0);

insert into treatment values('1', 'Extractions','1','2021-01-01',null,null
                            ,0);
insert into treatment values('2', 'Vaccine','1','2021-01-01',null,null
                            ,0);
insert into treatment values('3', 'Hairdressing','1','2021-01-01',null,null
                            ,0);


insert into vet_treatment values(1, 1,1,2,0,Now(),null,null,0);
insert into vet_treatment values(2, 1,2,2,0,Now(),null,null,0);
insert into vet_treatment values(3, 2,1,2,0,Now(),null,null,0);
insert into vet_treatment values(4, 2,3,2,0,Now(),null,null,0);

insert into veter_working_schedule values('1', '1','1','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('2', '1','2','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('3', '1','3','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('4', '1','4','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('5', '1','5','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('6', '2','1','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('7', '2','2','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('8', '2','3','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('9', '2','4','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('10', '2','5','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');
insert into veter_working_schedule values('11', '3','1','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('12', '3','2','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('13', '3','3','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('14', '3','4','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter_working_schedule values('15', '3','5','1970-01-01 08:00:00','1970-01-01 18:00:00'
                                         ,'1','2021-01-01 00:00:00',null,null,'0');


insert into vet values('1', 'testVetName01','Test Vet Description','50 Nanyang Ave, 639798','1970-01-01 08:00:00'
                      ,'1970-01-01 18:00:00','750231',1,1,'8210000','8210000','1','2021-01-01 00:00:00',null,null,'0');
insert into vet values('2', 'testVetName02','Test Vet Description','05 Nanyang Ave, 639798','1970-01-01 08:00:00'
                      ,'1970-01-01 18:00:00','750123',1,1,'8210000','8210000','1','2021-01-01 00:00:00',null,null,'0');

delimiter $$
drop procedure if exists wk;
create procedure wk();
begin
declare i, j int;

set i =0;
set j=0;
while i <11 do
insert into veter values(i, 'Doctor Wang','j','desc', true,false,null,null,0,'2021-01-01 00:00:00',null,null,false);
set i = i+1;
end while;
end $$
insert into appointment values('1', 'APPOINT00000001','2021-03-03','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user01','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
insert into appointment values('2', 'APPOINT00000002','2021-03-04','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user02','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
insert into appointment values('3', 'APPOINT00000003','2021-03-30','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user01','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
insert into appointment values('4', 'APPOINT00000004','2021-04-06','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'2'  ,'user02','1','3','2','3','1','2021-03-31 00:00:00',null,null,0);
insert into appointment values('5', 'APPOINT00000005','2021-04-07','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'2'  ,'user02','1','3','2','1','1','2021-03-31 00:00:00',null,null,0);