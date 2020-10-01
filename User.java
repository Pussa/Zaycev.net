class User {
    private long id;
    private String vacancy;

    public User (long id,String vacancy){
        this.id = id;
        this.vacancy = vacancy;

    }
    String getVacancy() {
        return vacancy;
    }
    long getId() {
        return id;
    }
    public static void main(String[] args) {
        User tester = new User(7,"Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
    }

}



//class Vacancy {
  //  String getVacancy() {
    //    return "engineer";
    //}
//}