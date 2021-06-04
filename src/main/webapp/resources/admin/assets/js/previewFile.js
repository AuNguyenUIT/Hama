$(document).ready(function () {
    $('#thumb').change(function () {
        showImageThumb(this);
    });

    $('#multiple_image').change(function () {
        showImages(this);
    })
});

function showImageThumb(fileInput) {
    file = fileInput.files[0];
    reader = new FileReader();
    reader.onload = function (e) {
        $("#thumb_preview").attr("src", e.target.result)
    }
    reader.readAsDataURL(file);
}

function showImages(filesInput) {
    $("#preview").empty();
    files = filesInput.files;
    for (var i = 0; i < files.length; i++) {
        file = files[i];
        reader = new FileReader();
        reader.onload = function (e) {
            var image = `<img class="m-2" width="150px" src= '${e.target.result}'/>`;
            $("#preview").append(image)
        }
        reader.readAsDataURL(file);
    }

}