class User{
    public static void main(String[]args){

        Employee tester=new Employee(7,"Developer");
        System.out.println(tester.getId());
        System.out.println(tester.getVacancy());
    }
}

class Employee {
    private long id;
    private Vacancy vacancy;

    public Employee(long id,String vac){
        this.id = id;
        this.vacancy = new Vacancy(vac);
    }

    String getVacancy() {
        return vacancy.getVacancy();
    }

    long getId() {
        return id;
    }
}

class Vacancy {
    String vacancy;
    public Vacancy(String vacancy){this.vacancy=vacancy;}
    String getVacancy() {
        return vacancy;
    }
}


