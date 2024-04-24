package com.example.tugas4praktikum;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<User> users = generateDummyUsers();

    private static ArrayList<User> generateDummyUsers(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("McLaren", "mclaren","McLaren, sebuah ikon di dunia otomotif, mewakili kelincahan dan kecepatan yang tak tertandingi. Dikembangkan dengan teknologi canggih dan desain aerodinamis yang memukau, setiap model McLaren adalah simbol dari performa tinggi dan presisi teknik. Dari mesin yang bertenaga hingga desain yang elegan namun agresif, setiap detail dipertimbangkan untuk memberikan pengalaman mengemudi yang tak terlupakan di jalanan dan lintasan.", R.drawable.mclarenlogo,R.drawable.mclarenpost));
        users.add(new User("ReddBull", "reddbull","Red Bull Racing adalah tim balap Formula 1 yang berbasis di Milton Keynes, Inggris, didirikan oleh Red Bull pada tahun 2005. Mereka telah sukses dengan beberapa kejuaraan dunia pembalap dan konstruktor, dikenal karena inovasi teknis, strategi balapan agresif, dan semangat persaingan yang kuat.",R.drawable.rbhondalog, R.drawable.rbhondapost ));
        users.add(new User("Ferrari", "ferrari","Ferrari F1, mencerminkan keunggulan teknik dan semangat balap yang mendalam. Sebagai salah satu tim Formula 1 paling sukses sepanjang sejarah, Ferrari telah menetapkan standar untuk inovasi dan kecepatan di lintasan balap. Mobil-mobil F1 Ferrari dirancang untuk memberikan performa maksimal, dengan teknologi canggih dan desain aerodinamis yang mutakhir. ",R.drawable.scuderia, R.drawable.ferrari ));
        users.add(new User("Visa Cash App RB F1 Team", "visacashapprb","Adalah tim balap Formula 1 yang berbasis di Faenza, Italia. Mereka adalah tim adik dari tim Red Bull Racing dan menjadi wadah bagi pembalap muda yang sedang berkembang. Sebelumnya dikenal sebagai Scuderia Toro Rosso,", R.drawable.visacashf1,R.drawable.visacashpostingan ));
        users.add(new User("Marcedes", "marcedesamg", "Mercedes-AMG Petronas Formula One Team adalah salah satu tim paling dominan dalam sejarah Formula 1. Didirikan pada tahun 2010 setelah akuisisi tim Brawn GP, Mercedes telah memenangkan banyak kejuaraan dunia pembalap dan konstruktor sejak saat itu. ",R.drawable.marcedeslog,R.drawable.marcedespost ));
        users.add(new User("Alfa Romeo", "alfaromeo","Alfa Romeo Racing ORLEN adalah tim balap Formula 1 yang berbasis di Hinwil, Swiss. Meskipun namanya terkait dengan merek mobil legendaris Italia, Alfa Romeo, tim ini sebenarnya dimiliki dan dioperasikan oleh Sauber Motorsport AG.",R.drawable.alfaromeolog,R.drawable.alfaromeostory ));
        return users;
    }


}
