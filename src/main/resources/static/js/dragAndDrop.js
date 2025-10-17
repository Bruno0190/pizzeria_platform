
const target = document.getElementById("imageFileArea");

function dropImage(ev){

    ev.preventDefault();

    let files = ev.dataTransfer.files;

    if(files.length > 0){

        const file = files[0];

        let fileUploaded = new DataTransfer();

        fileUploaded.items.add(file);

        target.files = fileUploaded.files;

    }

}

target.addEventListener("dragover", (ev) => {ev.preventDefault();});
target.addEventListener("drop", dropImage);
