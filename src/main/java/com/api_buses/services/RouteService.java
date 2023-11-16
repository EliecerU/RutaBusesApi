package com.api_buses.services;

import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;
// import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.api_buses.models.RouteModel;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.internal.NonNull;

import io.grpc.netty.shaded.io.netty.util.internal.ThreadLocalRandom;

@Service
public class RouteService {

    public static int randomNumberInRange(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    @NonNull
    static String generateIdRandom(){

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String string = "";
        for (int x = 0; x < 20; x++) {
            int indiceAleatorio = randomNumberInRange(0, characters.length() - 1);
            char caracterAleatorio = characters.charAt(indiceAleatorio);
            string += caracterAleatorio;
        }

        return string;

    }

    public ArrayList<RouteModel> getRoutes() throws InterruptedException, ExecutionException {

        ArrayList<RouteModel> routes = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();
        CollectionReference dReference = db.collection("Routes");
        ApiFuture<QuerySnapshot> future = dReference.get();
        QuerySnapshot colletion = future.get();
        
        colletion.forEach(doc -> {
            routes.add(doc.toObject(RouteModel.class));
            // System.out.println(routes.get(0).getName());
        });

        return routes;
    }

    public void postRoute(RouteModel route) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("Routes").document(generateIdRandom()).set(route);
        // return collection.get().getUpdateTime().toString();
    }

    public void delete(String id) {
    }

    public RouteModel putRoute(String id, RouteModel route) {
        return null;
    }

}
