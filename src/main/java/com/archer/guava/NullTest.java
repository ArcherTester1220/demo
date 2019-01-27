package com.archer.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

import java.io.Serializable;

public class NullTest {
    public static void main(String[] args) {

        Student s = null;
        Optional<Student> optional = Optional.fromNullable(s);
        if (optional.isPresent()) {
            System.out.println("isPresent:" + s.getPersion());
        } else {
            System.out.println("NULL");
        }
        System.out.println(optional.orNull());

        Persion persion = new Persion();
        persion.setAge(-1);
    }

    static class Student implements Serializable {
        private String name;
        private Persion persion;

        public Persion getPersion() {
            return persion;
        }

        public void setPersion(Persion persion) {
            this.persion = persion;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Persion {
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            Preconditions.checkArgument(age > 0, "Illegal Argument passed: Age must bigger than zero .", age);
            this.age = age;
        }
    }
}
