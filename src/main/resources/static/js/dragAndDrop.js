// Seleziono l’elemento HTML con id="imageFileArea".
// È l'elemento della pagina dove voglio gestire il drag & drop (ad esempio un <input type="file"> o un <div>)
const target = document.getElementById("imageFileArea");


// Definisco la funzione che verrà chiamata quando un file viene rilasciato sopra il target
function dropImage(ev) {

    // "ev" è l'oggetto evento (in questo caso un DragEvent)
    // Viene passato automaticamente dal browser quando avviene l’evento "drop"

    // Blocca il comportamento predefinito del browser (che altrimenti cercherebbe di aprire il file)
    ev.preventDefault();

    // Ogni evento di tipo "drag" o "drop" ha una proprietà "dataTransfer" che è un oggetto di classe DataTransfer, creato dal browser, che contiene e mantiene i dati trascinati (in questo caso i file)
    let files = ev.dataTransfer.files;

    // "files" è una FileList, simile a un array, che contiene tutti i file trascinati
    if (files.length > 0) {

        // Prendo il primo file della lista
        const file = files[0];

        // Creo manualmente un nuovo oggetto DataTransfer
        // (una "nuova istanza" della classe nativa DataTransfer)
        let fileUploaded = new DataTransfer();

        // Aggiungo il file trascinato all'oggetto DataTransfer appena creato
        fileUploaded.items.add(file);

        // Assegno la lista dei file del mio nuovo DataTransfer come "valore" dell'input file (cioè target.files) in questo modo è come se l’utente avesse selezionato quel file manualmente
        target.files = fileUploaded.files;
    }
}


// Aggiungo un listener per l'evento "dragover" per il rilascio del file sopra l’area (senza questo, il drop non funzionerebbe)
target.addEventListener("dragover", (ev) => {
    ev.preventDefault();
});

//Qui succede tutto: aggiungendo l’evento "drop", quando l’utente rilascia il file, viene eseguita la funzione dropImage descritta sopra
target.addEventListener("drop", dropImage);
