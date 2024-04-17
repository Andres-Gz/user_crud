package org.example.usercrud.commons.dto;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import org.example.usercrud.commons.util.Views;

public class UserDTO {

    @JsonView(Views.Read.class)
    private long id;

    @JsonView({Views.Create.class, Views.Update.class})
    @Schema(example = "Andres", description = "Nombre del usuario")
    private String name;

    @JsonView({Views.Create.class, Views.Update.class})
    @Schema(example = "Garces", description = "Apellido del usuario")
    private String lastname;

    @JsonView({Views.Create.class, Views.Update.class})
    @Schema(example = "22", description = "Edad del usuario")
    private int age;

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
