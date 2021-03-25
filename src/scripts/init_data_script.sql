insert into user values('1', 'user01','user 01','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','2021-01-01','123@email.com','820000'
                       ,1,'G140022P','0','1',2,'2021-01-01',null,null,0);

insert into user values('2', 'admin01','admin 01','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','2021-01-01','1234@email.com','820000'
                       ,1,'G140022P','1','1',2,'2021-01-01',null,null,0);

insert into treatment values('1', 'Extractions','1','2021-01-01',null,null
                            ,0);

insert into vet_treatment values(1, 1,1,2,0,Now(),null,null,0);

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


insert into vet values('1', 'testVetName','Test Vet Description','50 Nanyang Ave, 639798','1970-01-01 08:00:00'
                      ,'1970-01-01 18:00:00'  ,'1','2021-01-01 00:00:00',null,null,'0');

insert into veter values('1', 'Doctor Wang','1','desc', true,false,null,null,0,'2021-01-01 00:00:00',null,null,false);
insert into veter values('2', 'Doctor Tan','1','desc', true,false,null,null,0,'2021-01-01 00:00:00',null,null,false);


insert into appointment values('1', 'APPOINT00000001','2021-03-03','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user01','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
insert into appointment values('2', 'APPOINT00000002','2021-03-04','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user01','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
insert into appointment values('3', 'APPOINT00000003','2021-03-30','1970-01-01 14:00:00','1970-01-01 16:00:00'
                              ,'1'  ,'user01','1','1','1','1','1','2021-03-03 00:00:00',null,null,0);
