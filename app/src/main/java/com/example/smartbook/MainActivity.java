package com.example.smartbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;
    static DynamicRVAdapter dynamicRVAdapter;
    private static RecyclerView recyclerView2;
    public static String libro="";

    public static ArrayList<DynamicRVModel> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregamos los items con las categorias al recyclerview
        ArrayList<StaticRvModel> item = new ArrayList<>();
        //los items son del tipo StaticRVModel que contiene los campos necesarios para añadir la información
        item.add(new StaticRvModel(R.drawable.cuadricula,"Todos"));
        item.add(new StaticRvModel(R.drawable.scream,"Terror"));
        item.add(new StaticRvModel(R.drawable.magic_wand,"Fantasia"));
        item.add(new StaticRvModel(R.drawable.aventuras,"Aventura"));

        recyclerView = findViewById(R.id.rv);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRvAdapter);

        //Agregamos a la lista de libros todos los libros.
        agregarLibrosAll();

        //Agregamos los items con los libros al recyclerview
        recyclerView2 = findViewById(R.id.rv_2);
        actualizar();

    }


    public static void actualizar() {
        dynamicRVAdapter = new DynamicRVAdapter(items);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView2.setAdapter(dynamicRVAdapter);
    }

    public static void agregarLibrosAll() {
        //Limpiamos nuestra lista
        items.clear();
        //los items son del tipo DynamicRVModel que contiene los campos necesarios para añadir la información
        items.add(new DynamicRVModel(R.drawable.la_llamada_de_cthulhu,"La llamada de Cthulhu","Un hombre descubre las notas de " +
                "su difunto tío y se ve envuelto en una conspiración que involucra a un antiguo dios " +
                "oceánico y sus violentos seguidores.","Febrero, 1928","H. P. Lovecraft"));
        items.add(new DynamicRVModel(R.drawable.el_color_surgido_del_espacio,"El color surgido del espacio",
                "Es la historia contada en primera persona de un ingeniero encargado de realizar el estudio para construcción de una presa en un " +
                        "recóndito paraje de Arkham al que todos llaman «el erial maldito».","Septiembre, 1927"
        ,"H. P. Lovecraft"));
        items.add(new DynamicRVModel(R.drawable.la_mascara_de_la_muerte_roja,"La mascara de la muerte roja",
                "En este relato una misteriosa peste ataca la ciudad de Próspero, príncipe de una ficticia nación, al cual le complacía darse todo tipo de placeres...",
                "Mayo, 1842","Edgar Allan Poe"));
        items.add(new DynamicRVModel(R.drawable.barba_azul,"Barba azul","La historia sitúa a la joven Saturnine de 25 años en búsqueda de alquiler, pese al misterio que ronda " +
                "sobre las desapariciones de las mujeres que habitan la emblemática residencia en Paris, visita la mansión para entrevistarse con su dueño, Elemirio, y obtener la habitación.",
                "1697","Charles Perrault"));
        items.add(new DynamicRVModel(R.drawable.el_famoso_cohete,"El famoso cohete","Un príncipe se iba a casar y esperaba desde hace un año a su novia: una princesa rusa que era tan blanca como su palacio de nieve. ...",
                "Mayo, 1888", "Oscar Wilde"));
        items.add(new DynamicRVModel(R.drawable.la_casa_hechizada,"La casa hechizada", "Un grupo de amigos se reúne en una casa aparentemente encantada con la intención de descubrir evidencias de lo sobrenatural.",
                "Diciembre, 1859","Charles Dickens"));
        items.add(new DynamicRVModel(R.drawable.la_mujer_loba,"La mujer loba", "Un padre se traslada con sus tres hijos a un bosque lejano, huyendo del asesinato de su esposa, a quien ha matado por infidelidad.",
                "1900","Frederick Marryat"));
        items.add(new DynamicRVModel(R.drawable.la_sirenita,"La sirenita","El día en que la menor de las princesas sirenas salió a la superficie, vio un barco donde viajaba el príncipe, del que se enamoró. El barco naufragó, y la sirena " +
                "salvó al príncipe de morir ahogado, dejándolo en la playa.","Abril, 1837","Hans Christian Andersen"));
        items.add(new DynamicRVModel(R.drawable.el_soldadito_de_plomo,"El intrepido soldadito de plomo",
        "El soldadito de plomo está enamorado de una bailarina de papel con una lentejuela en el vestido que también se mueve sobre una sola pierna.",
        "Octubre, 1838","Hans Christian Andersen"));
    }

    public static void  agregarLibrosTerror(){
        //Limpiamos nuestra lista
        items.clear();
        items.add(new DynamicRVModel(R.drawable.la_llamada_de_cthulhu,"La llamada de Cthulhu","Un hombre descubre las notas de " +
                "su difunto tío y se ve envuelto en una conspiración que involucra a un antiguo dios " +
                "oceánico y sus violentos seguidores.","Febrero, 1928","H. P. Lovecraft"));
        items.add(new DynamicRVModel(R.drawable.el_color_surgido_del_espacio,"El color surgido del espacio",
                "Es la historia contada en primera persona de un ingeniero encargado de realizar el estudio para construcción de una presa en un " +
                        "recóndito paraje de Arkham al que todos llaman «el erial maldito».","Septiembre, 1927"
                ,"H. P. Lovecraft"));
        items.add(new DynamicRVModel(R.drawable.la_mascara_de_la_muerte_roja,"La mascara de la muerte roja",
                "En este relato una misteriosa peste ataca la ciudad de Próspero, príncipe de una ficticia nación, al cual le complacía darse todo tipo de placeres...",
                "Mayo, 1842","Edgar Allan Poe"));
    }
    public static void  agregarLibrosFantasia(){
        //Limpiamos nuestra lista
        items.clear();
        items.add(new DynamicRVModel(R.drawable.la_mujer_loba,"La mujer loba", "Un padre se traslada con sus tres hijos a un bosque lejano, huyendo del asesinato de su esposa, a quien ha matado por infidelidad.",
                "1900","Frederick Marryat"));
        items.add(new DynamicRVModel(R.drawable.la_sirenita,"La sirenita","El día en que la menor de las princesas sirenas salió a la superficie, vio un barco donde viajaba el príncipe, del que se enamoró. El barco naufragó, y la sirena " +
                "salvó al príncipe de morir ahogado, dejándolo en la playa.","Abril, 1837","Hans Christian Andersen"));
        items.add(new DynamicRVModel(R.drawable.la_casa_hechizada,"La casa hechizada", "Un grupo de amigos se reúne en una casa aparentemente encantada con la intención de descubrir evidencias de lo sobrenatural.",
                "Diciembre, 1859","Charles Dickens"));
    }
    public  static void  agregarLibrosAventura(){
        //Limpiamos nuestra lista
        items.clear();
        items.add(new DynamicRVModel(R.drawable.barba_azul,"Barba azul","La historia sitúa a la joven Saturnine de 25 años en búsqueda de alquiler, pese al misterio que ronda " +
                "sobre las desapariciones de las mujeres que habitan la emblemática residencia en Paris, visita la mansión para entrevistarse con su dueño, Elemirio, y obtener la habitación.",
                "1697","Charles Perrault"));
        items.add(new DynamicRVModel(R.drawable.el_famoso_cohete,"El famoso cohete","Un príncipe se iba a casar y esperaba desde hace un año a su novia: una princesa rusa que era tan blanca como su palacio de nieve. ...",
                "Mayo, 1888", "Oscar Wilde"));
        items.add(new DynamicRVModel(R.drawable.el_soldadito_de_plomo,"El intrepido soldadito de plomo",
                "El soldadito de plomo está enamorado de una bailarina de papel con una lentejuela en el vestido que también se mueve sobre una sola pierna.",
                "Octubre, 1838","Hans Christian Andersen"));
    }

}