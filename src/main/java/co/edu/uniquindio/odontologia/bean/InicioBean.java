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
    private transient OdontologoServicio odontologoServicio;

    @Getter
    @Setter
    private List<String> imagenes;



    @PostConstruct
    public void init (){
        try{
            imagenes = new ArrayList<>();
            imagenes.add("https://www.teeth22.com/wp-content/uploads/2020/03/absceso-dental-1024x511.png");
            imagenes.add("https://staticnew-prod.topdoctors.cl/files/Image/large/226302beaa60ee5802b6efaf2afecb18.jpg");
            imagenes.add("https://mafercamargo.com/wp-content/uploads/2021/03/servicio_Odontologia_laser_Bogota_Mafer_Camargo-1024x538.jpg");
            imagenes.add("https://img.genial.ly/60ea5207a0a9040fc032feff/fd51acc0-056b-4d57-8cc1-02231e623ea6.png");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
