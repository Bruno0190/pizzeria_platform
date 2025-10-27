package org.progetti.java.spring.pizzeria_platform.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.*;

@Service
public class FileStorage {
    
    //L'oggetto FileStorage viene creato da Spring usando il costruttore vuoto implicito.
    // Nessun costruttore scritto = Java ne crea uno vuoto automaticamente.
    //Perchè funziona in questa classe in particolare? Perché non ci sono campi da inizializzare.
    //Questa classe esiste solo per il metodo storeFile che prevede di ricevere un oggetto MultipartFile come argomento. Ma allo stesso tempo non ha senso avere un costruttore che riceve un MultipartFile perché l'oggetto FileStorage non deve mantenere uno stato con quel file.
    //MultipartFile è un'interfaccia che rappresenta un file caricato in un'applicazione web. Viene utilizzata per gestire i file caricati dagli utenti tramite form HTML.
   
    public String storeFile(MultipartFile file){

        if(file.isEmpty()) {
            return null;
        } else {
            String directoryPath = "C:/Users/black/Desktop/Boolean/esercizi/pizzeria_platform/src/main/resources/static/images/";
            //getOriginalFilename() restituisce il nome originale del file caricato, inclusa l'estensione.
            String filePath = directoryPath + file.getOriginalFilename();
            try {
                //Files è una classe di utilità in java.nio.file che fornisce metodi statici per operazioni sui file e sulle directory.
                //getInputStream() restituisce un InputStream per leggere il contenuto del file caricato.
                //Paths è una classe di utilità che fornisce metodi per creare oggetti Path da stringhe di percorso.
                Files.copy(file.getInputStream(), Paths.get(filePath));
            } catch (IOException e) {
                return null; // o gestire l'errore
            }

        }

        return "/images/" + file.getOriginalFilename();  // ← URL per il browser
       
    }

}
