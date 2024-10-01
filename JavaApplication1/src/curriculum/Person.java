package curriculum;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antonio
 */
public class Person {
    
    private int personId;
    private String nome;
    private int age;
    private int curriculumId;
    
    
    public Person(){
        
    }
    
    public Person(int personId, int age, int curriculumId, String nome){
        this.age = age;
        this.personId = personId;
        this.curriculumId = curriculumId;
        this.nome = nome;
    }

    /**
     * @return the personId
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the curriculumId
     */
    public int getCurriculumId() {
        return curriculumId;
    }

    /**
     * @param curriculumId the curriculumId to set
     */
    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }
    
    
    
}
