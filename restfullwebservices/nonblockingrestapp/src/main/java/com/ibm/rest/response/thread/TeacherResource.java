package com.ibm.rest.response.thread;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("teachers")
public class TeacherResource {

    //Return single Teacher
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Teacher> getTeacher() {
        System.out.println(Thread.currentThread().getName());
        Teacher teacher = new Teacher(1l, "Subramanian", "Quarkus");
        return Uni.createFrom().item(teacher);
    }

    //Return Collection
    @GET
    @Path("list")
    public Uni<List<Teacher>> getTeachers() {
        System.out.println(Thread.currentThread().getName());
        List<Teacher> teacherList = List.of(
                new Teacher(1l, "Subramanian", "Quarkus"),
                new Teacher(2l, "Murugan", "Quarkus"),
                new Teacher(3l, "Karthik", "Spring Framework")
        );
        return Uni.createFrom().item(teacherList);
    }
}
