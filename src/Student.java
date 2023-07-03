public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        this.mat.yuzde=0.20;
        this.fizik.yuzde=0.30;
        this.kimya.yuzde=0.20;
        this.mat.verbal= mat.verbal;
        this.fizik.verbal= fizik.verbal;
        this.kimya.verbal= kimya.verbal;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }


        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }
    public void addBulkVerbalExamNote(int mat,int fizik,int kimya){

        if(this.mat.verbal>=0&&this.mat.verbal<=100){
            this.mat.verbal=mat;
        }
        if(this.fizik.verbal>=0&&this.fizik.verbal<=100){
            this.fizik.verbal=fizik;
        }
        if(this.kimya.verbal>=0&&this.kimya.verbal<=100){
            this.kimya.verbal=kimya;
        }
    }


    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0 || this.mat.verbal==0 || this.kimya.verbal==0 || this.fizik.verbal==0) {
            System.out.println("Notlar veya sözlüler tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = ((this.fizik.note*(1-this.fizik.yuzde)+this.fizik.verbal*this.fizik.yuzde)+ (this.kimya.note*(1-this.kimya.yuzde)+this.kimya.verbal*this.kimya.yuzde) + (this.mat.note*(1-this.mat.yuzde)+this.mat.verbal*this.mat.yuzde) )/ 3.0;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Matematik Sozlu : " + this.mat.verbal);
        System.out.println("Fizik Sozlu : " + this.fizik.verbal);
        System.out.println("Kimya Sozlu : " + this.kimya.verbal);
    }

}
