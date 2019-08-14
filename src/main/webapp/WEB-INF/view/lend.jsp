<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 9.08.2019
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        /* In order to place the tracking correctly */
        canvas.drawing, canvas.drawingBuffer {
            position: absolute;
            left: 0;
            top: 0;
        }
    </style>
    <script src="https://cdn.rawgit.com/serratus/quaggaJS/0420d5e0/dist/quagga.min.js"></script>
</head>
<body>
<h3>Raamatu laenutamine</h3>


<!-- Div to show the scanner-->
<div id="scanner-container"></div>
<input type="button" id="btn" value="Start/Stop the scanner" />
<br />

<!--<input type="text" id="barcode">
<a href="/app/book/{barcode}">Laenuta</a>
<a href="/app//lend/{barCode}">Laenuta</a>-->


<form action="/app/search" method="post">
    Triipkood: <input type="text" name="barcode" id="barcode"><br>
    <input type="submit" value="Edasi">
</form>

<!-- Include the image-diff library -->
<!--<script src="quagga.min.js"></script>-->

<script>
    var _scannerIsRunning = false;
    function startScanner() {
        Quagga.init({
            inputStream: {
                name: "Live",
                type: "LiveStream",
                target: document.querySelector('#scanner-container'),
                constraints: {
                    width: 880,
                    height: 640,
                    facingMode: "environment"
                },
            },
            decoder: {
                readers: [
                    "code_128_reader",
                    "ean_reader",
                    "ean_8_reader",
                    "code_39_reader",
                    "code_39_vin_reader",
                    "codabar_reader",
                    "upc_reader",
                    "upc_e_reader",
                    "i2of5_reader"
                ],
                debug: {
                    showCanvas: true,
                    showPatches: true,
                    showFoundPatches: true,
                    showSkeleton: true,
                    showLabels: true,
                    showPatchLabels: true,
                    showRemainingPatchLabels: true,
                    boxFromPatches: {
                        showTransformed: true,
                        showTransformedBox: true,
                        showBB: true
                    }
                }
            },
        }, function (err) {
            if (err) {
                console.log(err);
                return
            }
            console.log("Initialization finished. Ready to start");
            Quagga.start();
            // Set flag to is running
            _scannerIsRunning = true;
        });
        Quagga.onProcessed(function (result) {
            var drawingCtx = Quagga.canvas.ctx.overlay,
                drawingCanvas = Quagga.canvas.dom.overlay;
            if (result) {
                if (result.boxes) {
                    drawingCtx.clearRect(0, 0, parseInt(drawingCanvas.getAttribute("width")), parseInt(drawingCanvas.getAttribute("height")));
                    result.boxes.filter(function (box) {
                        return box !== result.box;
                    }).forEach(function (box) {
                        Quagga.ImageDebug.drawPath(box, { x: 0, y: 1 }, drawingCtx, { color: "green", lineWidth: 2 });
                    });
                }
                if (result.box) {
                    Quagga.ImageDebug.drawPath(result.box, { x: 0, y: 1 }, drawingCtx, { color: "#00F", lineWidth: 2 });
                }
                if (result.codeResult && result.codeResult.code) {
                    Quagga.ImageDebug.drawPath(result.line, { x: 'x', y: 'y' }, drawingCtx, { color: 'red', lineWidth: 3 });
                }
            }
        });
        Quagga.onDetected(function (result) {
            console.log("Barcode detected and processed : [" + result.codeResult.code + "]", result);
            document.getElementById("barcode").value = result.codeResult.code;
        });
    }
    // Start/stop scanner
    document.getElementById("btn").addEventListener("click", function () {
        if (_scannerIsRunning) {
            Quagga.stop();
        } else {
            startScanner();
        }
    }, false);
    startScanner();
</script>


</body>
</html>
