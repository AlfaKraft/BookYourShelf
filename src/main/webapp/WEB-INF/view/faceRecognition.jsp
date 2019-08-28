<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 27.08.2019
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Face recognition</title>

</head>
<body>

<video id="video" width="640" height="480" autoplay></video>
<button id="snap">Snap Photo</button>
<canvas id="canvas" width="640" height="480"></canvas>

<script>
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');
    var video = document.getElementById('video');

    // Get access to the camera!
    if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
        // Not adding `{ audio: true }` since we only want video now
        navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
            //video.src = window.URL.createObjectURL(stream);
            video.srcObject = stream;
            video.play();
        });
    }

    // Trigger photo take
    document.getElementById("snap").addEventListener("click", function() {
        context.drawImage(video, 0, 0, 640, 480);
        ///var canvas = document.getElementById('canv');
        //var dataURL = context.toDataURL("image/png");
        var dataURL = canvas.toDataURL("image/png");
        // var canvas = document.getElementById('canvas');
        document.getElementById('imageBase64').value = dataURL;
    });
</script>


<form method="POST" action="/app/uploadImage" >
    <input type="hidden" name="imageBase64" id="imageBase64"/><br/><br/>
    <input type="submit" value="Identify" />
</form>
</body>
</html>
