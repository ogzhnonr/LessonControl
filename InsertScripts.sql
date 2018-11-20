/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE(type)
VALUES ('USER');
  
INSERT INTO USER_PROFILE(type)
VALUES ('ADMIN');
  
INSERT INTO USER_PROFILE(type)
VALUES ('PARENT');
  
  
/* Populate one Admin User which will further create other users for the application using GUI */
INSERT INTO APP_USER(sso_id, password, first_name, last_name, email)
VALUES ('sam','$2a$10$4eqIF5s/ewJwHK1p8lqlFOEm2QIA0S8g6./Lok.pQxqcxaBZYChRm', 'Sam','Smith','samy@xyz.com');
  
  
/* Populate JOIN Table */
INSERT INTO APP_USER_USER_PROFILE (user_id, user_profile_id)
  SELECT user.id, profile.id FROM APP_USER user, USER_PROFILE profile
  where user.sso_id='sam' and profile.type='ADMIN';
 
--benim de�erler
--Insert into tasks
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	1,	1,	'TYT Matematik'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	2,	1,	'TYT Geometri'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	3,	1,	'TYT Fizik'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	4,	1,	'TYT Kimya'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	5,	1,	'TYT Biyoloji'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	6,	1,	'TYT T�rk�e'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	7,	1,	'TYT Tarih'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	8,	1,	'TYT Co�rafya'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	9,	1,	'TYT Din'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	10,	1,	'TYT Felsefe'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	11,	2,	'YKS Matematik'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	12,	2,	'YKS Geometri'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	13,	2,	'YKS Fizik'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	14,	2,	'YKS Kimya'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	15,	2,	'YKS Biyoloji'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	16,	2,	'YKS Edebiyat'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	17,	2,	'YKS Tarih 1'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	18,	2,	'YKS Co�rafya 1'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	19,	2,	'YKS Tarih 2'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	20,	2,	'YKS Co�rafya 2'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	21,	2,	'YKS Din'	);
INSERT INTO verilh12_websystique.TASK(taskId,parentId,taskName) VALUES (	22,	2,	'YKS Felsefe'	);


--insesrt into taskdetail
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	1,	'Say�lar'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	2,	'Say� Basamaklar�-> 2-2'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	3,	'B�lme ve B�l�nebilme'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	4,	'OBEB-OKEK'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	5,	'Rasyonel Say�lar-> 1-1'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	6,	'Basit E�itsizlikler-> 1-1'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	7,	'Mutlak De�er-> 1-1'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	8,	'�sl� Say�lar-> 2-2'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	9,	'K�kl� Say�lar-> 3-3'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	10,	'�arpanlara Ay�rma-> 1-0'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	11,	'Oran Orant�-> 1-0'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	12,	'Denklem ��zme'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	13,	'Problemler-> 13-12'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	14,	'K�meler-> 1-2'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	15,	'Fonksiyonlar-> 1-1'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	16,	'Perm�tasyon'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	17,	'Kombinasyon'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	18,	'Binom'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	19,	'Olas�l�k-> 1-1'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	20,	'�statistik'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	21,	'2. Dereceden Denklemler'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	22,	'Karma��k Say�lar'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	23,	'Parabol'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	24,	'Polinomlar'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	25,	'��lem-> 1-0'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	26,	'Temel Kavramlar-> 4-2'	);
INSERT INTO verilh12_websystique.TASKDETAIL(taskId,taskDetailId,taskDetailName) VALUES (	1,	27,	'Mod�ler Aritmetik-> 0-1'	);
