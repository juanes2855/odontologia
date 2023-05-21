package co.edu.uniquindio.odontologia.bean;

import co.edu.uniquindio.odontologia.servicios.OdontologoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {

    @Autowired
    private OdontologoServicio odontologoServicio;

    @Getter
    @Setter
    private List<String> imagenes;



    @PostConstruct
    public void init (){
        try{
            imagenes = new ArrayList<>();
            imagenes.add("https://www.teeth22.com/wp-content/uploads/2020/03/absceso-dental-1024x511.png");
            imagenes.add("https://media.istockphoto.com/id/1399395748/es/foto/alegre-mujer-de-negocios-con-gafas-posando-con-las-manos-bajo-la-cara-mostrando-su-sonrisa-en.jpg");
            imagenes.add("https://wallpaperaccess.com/full/37960.jpg");
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
