<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head >
    <meta charset="UTF-8">
    <title>Расчёт волновода</title>
    <script>
        let layers = [];

        function addLayer() {
            const E = document.getElementById("E").value;
            const A = document.getElementById("A").value;
            const B = document.getElementById("B").value;
            const H = document.getElementById("H").value;
            layers.push({ E: parseFloat(E), A: parseFloat(A), B: parseFloat(B), H: parseFloat(H) });

            const table = document.getElementById("layerTable");
            table.innerHTML += `<tr><td>${E}</td><td>${A}</td><td>${B}</td><td>${H}</td></tr>`;
        }

        async function calculate() {
            const response = await fetch("/waveguide/calculate", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(layers)
            });
            const data = await response.json();

            document.getElementById("result").innerHTML = `
        <p>neffTM: ${data.neffTM}</p>
        <p>alphaTM: ${data.alphaTM}</p>
        <p>alphaTMWG: ${data.alphaTMWG}</p>
        <p>alpha4TMWG: ${data.alpha4TMWG}</p>
        <img src="data:image/png;base64,${data.plot_base64}" />
      `;
        }
    </script>
</head>
<body>
<h2>Добавить слой</h2>
<input id="E" placeholder="E" type="text">
<input id="A" placeholder="A" type="text">
<input id="B" placeholder="B" type="text">
<input id="H" placeholder="H" type="text">
<button onclick="addLayer()">Добавить слой</button>

<table id="layerTable" border="1">
    <tr><th>E</th><th>A</th><th>B</th><th>H</th></tr>
</table>

<button onclick="calculate()">Рассчитать</button>

<div id="result"></div>
</body>
</html>
