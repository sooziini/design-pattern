public class Main {
    public static void main(String[] args) {
        PasswordInfo pw;
        PasswordDAO pwDao = new PasswordDAOImpl();

        System.out.println("INSERTING...");
        pw = new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde");
        pwDao.insert(pw);
        pw = new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde");
        pwDao.insert(pw);

        System.out.println("FINDING ALL...");
        for (PasswordInfo pi : pwDao.findAll())
            System.out.println("reading... "+pi);

        System.out.println("UPDATING...");
        pw = pwDao.findAll().get(1);
        pw.setId("smu1");
        pwDao.update(pw);

        String url2 = "https://www.smu2.ac.kr";
        System.out.println("SEE IF UPDATED...");
        pw = pwDao.findByKey(url2);
        if (pw != null)
            System.out.println(pw);

        System.out.println("DELETING...");
        pwDao.delete(url2);

        System.out.println("FINDING ALL AFTER DELETING...");
        for (PasswordInfo pi : pwDao.findAll())
            System.out.println("reading... "+pi);
    }
}
