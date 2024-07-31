package com.ibm.rest.api.payload;

import com.ibm.rest.api.payload.entity.Teacher;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("teacher")
public class TeacherResource {

    @POST
    public String save(Teacher teacher) {
        System.out.println(teacher);
        return "saved";
    }

    //Return single Teacher
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Teacher getTeacher() {
        return new Teacher(1l, "Subramanian", "Quarkus");
    }

    //Return Collection
    @GET
    @Path("list")
    public List<Teacher> getTeachers() {
        List<Teacher> teacherList = List.of(
                new Teacher(1l, "Subramanian", "Quarkus"),
                new Teacher(2l, "Murugan", "Quarkus"),
                new Teacher(3l, "Karthik", "Spring Framework")
        );
        return teacherList;
    }

    @DELETE
    @Path("{Id}")
    public void remove(@PathParam("Id") Long id) {
        //return status is 204-No content
        System.out.println("delete by Id" + id);
    }
}
