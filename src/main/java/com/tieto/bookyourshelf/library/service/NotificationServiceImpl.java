package com.tieto.bookyourshelf.library.service;

import com.tieto.bookyourshelf.library.dao.BorrowDao;
import com.tieto.bookyourshelf.library.dao.entityes.BorrowEnt;
import com.tieto.bookyourshelf.library.service.dto.BookDto;
import com.tieto.bookyourshelf.library.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    public MailSender mailSender;
    private SimpleMailMessage templateMessage;

    @Autowired
    BorrowDao borrowDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @Scheduled(cron="0 18 14 ? * MON-FRI")
    public void sendNotification() {

        try {
            sendLateNotification();
        } catch (Exception e) {
        }

        try {
            sendPreNotification();
        }
        catch (Exception e) {
        }
    }

    public void sendLateNotification() {
        Date date = new Date();

        List<BorrowEnt> borrowsWithDueDatesExpired = borrowDao.findBorrowEntByDateToBringBeforeAndDateBroughtIsNull(date);
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

        for (int i = 0; i < borrowsWithDueDatesExpired.size(); i++) {

            UserDto user = userService.getUserById(borrowsWithDueDatesExpired.get(i).getIdUser());
            BookDto book = bookService.getBookById(borrowsWithDueDatesExpired.get(i).getIdBook());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            msg.setTo(user.getEmail());
            msg.setText("Dear "+user.getFirstName()+","+
                    "\n\n" +
                    "The return date of your book " + "\""+
                    book.getTitle()+"\" " +
                    "is approaching (" +
                            dateFormat.format(borrowsWithDueDatesExpired.get(i).getDateToBring())+
                    ")." +
                    "\n\n" +
                    "Your BookYourShelf" );
            try{
                this.mailSender.send(msg);
            }
            catch(MailException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public void sendPreNotification() {

        Date start = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.DATE, 2);
        start = c.getTime();

        Date end = new Date();
        Calendar d = Calendar.getInstance();
        d.setTime(end);
        d.add(Calendar.DATE, 4);
        end = d.getTime();

        List<BorrowEnt> borrowsWithDueDatesExpired = borrowDao.findBorrowEntByDateToBringIsBetweenAndDateBroughtIsNull(start,end);
        SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);

        for (int i = 0; i < borrowsWithDueDatesExpired.size(); i++) {

            UserDto user = userService.getUserById(borrowsWithDueDatesExpired.get(i).getIdUser());
            BookDto book = bookService.getBookById(borrowsWithDueDatesExpired.get(i).getIdBook());
            msg.setTo(user.getEmail());
            msg.setText(
                    "Dear user, deadline is coming" +
                            "\n\n" +
                            "please return " +
                            book.getTitle()+"!"+
                            "\n\n" +
                            "Your Library " );
            try{
                this.mailSender.send(msg);
            }
            catch(MailException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
