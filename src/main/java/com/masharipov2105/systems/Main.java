package com.masharipov2105.systems;

import com.masharipov2105.systems.controller.*;
import com.masharipov2105.systems.service.*;
import com.masharipov2105.systems.exceptions.StudentException;

public class Main {
    
    public static void main(String[] args) throws StudentException{

        StudentService service = new StudentServiceImpl();
        StudentController controller = new StudentController(service);

        controller.start();
        
    }
}
