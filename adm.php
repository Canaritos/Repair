<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script defer src="theme.js"></script>

    <link rel="stylesheet" href="style-adm.css" />
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@500;700&family=Lobster&display=swap" rel="stylesheet" />

    <script src="https://use.fontawesome.com/bcb5fbec7d.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet" />

    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

    <title>Repair - Home</title>
</head>

<body>

    <?php 
    @session_start(); 
    if(!isset($_SESSION['usuario'])){
    header("Location: index.php"); 
    exit();
    }
    ?>


    <nav class="navbar">
        <ul class="navbar-nav">
            <li class="logo">
                <a href="#" class="nav-link" style="height: 5rem;">
                    Repair
                </a>
            </li>

            <li class="nav-item">
                <a href="adm.php" class="nav-link" title="Home">
                    <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-home fa-2x" aria-hidden="true"></i> </path>
                </a>
            </li>

            <li class="nav-item">
                <a href="cadastrosAdm.php" class="nav-link" title="Adicione">
                    <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-user-plus fa-2x" aria-hidden="true"></i></path>
                </a>
            </li>

            <li class="nav-item">
                <a href="chamados.php" class="nav-link" title="Chamados enviados">
                    <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-exclamation-circle fa-2x" aria-hidden="true"></i></path>
                </a>
            </li>

            <li class="nav-item">
                <a href="chamados.php" class="nav-link" title="Configuração">
                    <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-cog fa-2x" aria-hidden="true"></i> <i class="fas fa-door-open"></i></path>
                </a>
            </li>


            <li class="nav-item" id="themeButton">
                <a href="#" class="nav-link" title="Mudar tema">
                    <svg class="theme-icon" id="lightIcon" aria-hidden="true" focusable="false" data-prefix="fad" data-icon="moon-stars" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" class="svg-inline--fa fa-moon-stars fa-w-16 fa-7x">
                        <g class="fa-group">
                            <path fill="currentColor" d="M320 32L304 0l-16 32-32 16 32 16 16 32 16-32 32-16zm138.7 149.3L432 128l-26.7 53.3L352 208l53.3 26.7L432 288l26.7-53.3L512 208z" class="fa-secondary"></path>
                            <path fill="currentColor" d="M332.2 426.4c8.1-1.6 13.9 8 8.6 14.5a191.18 191.18 0 0 1-149 71.1C85.8 512 0 426 0 320c0-120 108.7-210.6 227-188.8 8.2 1.6 10.1 12.6 2.8 16.7a150.3 150.3 0 0 0-76.1 130.8c0 94 85.4 165.4 178.5 147.7z" class="fa-primary"></path>
                        </g>
                    </svg>
                    <svg class="theme-icon" id="solarIcon" aria-hidden="true" focusable="false" data-prefix="fad" data-icon="sun" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" class="svg-inline--fa fa-sun fa-w-16 fa-7x">
                        <g class="fa-group">
                            <path fill="currentColor" d="M502.42 240.5l-94.7-47.3 33.5-100.4c4.5-13.6-8.4-26.5-21.9-21.9l-100.4 33.5-47.41-94.8a17.31 17.31 0 0 0-31 0l-47.3 94.7L92.7 70.8c-13.6-4.5-26.5 8.4-21.9 21.9l33.5 100.4-94.7 47.4a17.31 17.31 0 0 0 0 31l94.7 47.3-33.5 100.5c-4.5 13.6 8.4 26.5 21.9 21.9l100.41-33.5 47.3 94.7a17.31 17.31 0 0 0 31 0l47.31-94.7 100.4 33.5c13.6 4.5 26.5-8.4 21.9-21.9l-33.5-100.4 94.7-47.3a17.33 17.33 0 0 0 .2-31.1zm-155.9 106c-49.91 49.9-131.11 49.9-181 0a128.13 128.13 0 0 1 0-181c49.9-49.9 131.1-49.9 181 0a128.13 128.13 0 0 1 0 181z" class="fa-secondary"></path>
                            <path fill="currentColor" d="M352 256a96 96 0 1 1-96-96 96.15 96.15 0 0 1 96 96z" class="fa-primary"></path>
                        </g>
                    </svg>
                    <svg class="theme-icon" id="darkIcon" aria-hidden="true" focusable="false" data-prefix="fad" data-icon="sunglasses" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512" class="svg-inline--fa fa-sunglasses fa-w-18 fa-7x">
                        <g class="fa-group">
                            <path fill="currentColor" d="M574.09 280.38L528.75 98.66a87.94 87.94 0 0 0-113.19-62.14l-15.25 5.08a16 16 0 0 0-10.12 20.25L395.25 77a16 16 0 0 0 20.22 10.13l13.19-4.39c10.87-3.63 23-3.57 33.15 1.73a39.59 39.59 0 0 1 20.38 25.81l38.47 153.83a276.7 276.7 0 0 0-81.22-12.47c-34.75 0-74 7-114.85 26.75h-73.18c-40.85-19.75-80.07-26.75-114.85-26.75a276.75 276.75 0 0 0-81.22 12.45l38.47-153.8a39.61 39.61 0 0 1 20.38-25.82c10.15-5.29 22.28-5.34 33.15-1.73l13.16 4.39A16 16 0 0 0 180.75 77l5.06-15.19a16 16 0 0 0-10.12-20.21l-15.25-5.08A87.95 87.95 0 0 0 47.25 98.65L1.91 280.38A75.35 75.35 0 0 0 0 295.86v70.25C0 429 51.59 480 115.19 480h37.12c60.28 0 110.38-45.94 114.88-105.37l2.93-38.63h35.76l2.93 38.63c4.5 59.43 54.6 105.37 114.88 105.37h37.12C524.41 480 576 429 576 366.13v-70.25a62.67 62.67 0 0 0-1.91-15.5zM203.38 369.8c-2 25.9-24.41 46.2-51.07 46.2h-37.12C87 416 64 393.63 64 366.11v-37.55a217.35 217.35 0 0 1 72.59-12.9 196.51 196.51 0 0 1 69.91 12.9zM512 366.13c0 27.5-23 49.87-51.19 49.87h-37.12c-26.69 0-49.1-20.3-51.07-46.2l-3.12-41.24a196.55 196.55 0 0 1 69.94-12.9A217.41 217.41 0 0 1 512 328.58z" class="fa-secondary"></path>
                            <path fill="currentColor" d="M64.19 367.9c0-.61-.19-1.18-.19-1.8 0 27.53 23 49.9 51.19 49.9h37.12c26.66 0 49.1-20.3 51.07-46.2l3.12-41.24c-14-5.29-28.31-8.38-42.78-10.42zm404-50l-95.83 47.91.3 4c2 25.9 24.38 46.2 51.07 46.2h37.12C489 416 512 393.63 512 366.13v-37.55a227.76 227.76 0 0 0-43.85-10.66z" class="fa-primary"></path>
                        </g>
                    </svg>
                </a>
            </li>
        </ul>
    </nav>

    <main style="padding: 0">
        <div class="logo-nav">
            <section>
                <ul class="nav-lateral">

                    <li> <a href="adm.php" class="nav-link-inferior" title="Notificação">
                            <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-bell fa-sm" aria-hidden="true"></i></path>
                        </a>
                    </li>

                    <li> <a href="adm.php" class="nav-link-inferior" title="Home">
                            <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-comments-o fa-lg" aria-hidden="true"></i></path>
                        </a>
                    </li>

                    <li> <a href="logout.php" class="nav-link-inferior" title="Sair">
                            <path fill="currentColor" d="M160,320h64V224H160Zm192-96v96h64V224Z" class="fa-primary"> <i class="fa fa-sign-out fa-lg" aria-hidden="true"></i></path>
                        </a>
                    </li>
                </ul>
            </section>

        </div>
        <div class="container" style="padding:0; padding-top:0.5rem">
            <div class="espaco" style="margin-top: 0rem;">Atualizado no dia 10/11/2010 <p class="legenda">ver mais</p>
            </div>

            <div class="dados">

                <section>
                    <ul class="container-graf">
                        <li class="sla">
                            <div class="desc-img" style="background:rgb(255, 255, 255, 0.4);"><i class="fa fa-user fa-lg" aria-hidden="true" style=" margin-left:35%;margin-top: 25%;color: rgb(230, 134, 34); "></i></div>
                            <div class="number">1234</div>
                            <div class="descrition">Usuários</div>
                        </li>
                        <li class="sla">
                            <div class="desc-img" style="background:rgb(255, 255, 255, 0.4);"><i class="fa fa-user fa-lg" aria-hidden="true" style=" margin-left:35%;margin-top: 25%;color:#434EB8"></i></div>
                            <div class="number">12</div>
                            <div class="descrition">Coordenadores</div>
                        </li>
                        <li class="sla">
                            <div class="desc-img" style="background:rgb(255, 255, 255, 0.4);"></div>
                            <div class="number">1234</div>
                            <div class="descrition">aaa</div>
                        </li>
                        <li class="sla">
                            <div class="desc-img" style="background:rgb(255, 255, 255, 0.4);"><i class="fa fa-check-square-o fa-lg" aria-hidden="true" style="  margin-left:35%;
                    margin-top: 25%;color:rgb(30, 221, 203);"></i></div>
                            <div class="number">1234</div>
                            <div class="descrition">Tarefas concluidas</div>
                        </li>
                        <li class="sla">
                            <div class="desc-img" style="background:rgb(255, 255, 255, 0.4);"> <i class="fa fa-exclamation-triangle fa-lg" aria-hidden="true" style="  margin-left:30%;
                    margin-top: 25%;color:rgb(243, 10, 10);"></i></div>
                            <div class="number">4</div>
                            <div class="descrition">Reclamações</div>
                        </li>
                    </ul>
                </section>
            </div>
            <div class="espaco">Título do gráfico</div>
            <div class="dados" style="">
                <section>
                    <ul class="graf">
                        <li class="grafico">
                            <div class="grafico-Um">
                                <div class="title">Titulo do Grafico</div>
                                <canvas id="myChart" class="canvas">

                                    <script>
                                        var ctx = document.getElementById('myChart').getContext("2d")
                                        var myChart = new Chart(ctx, {
                                            type: 'line',
                                            data: {
                                                labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL"],
                                                datasets: [{
                                                    label: "Data",
                                                    borderColor: "rgb(67, 78, 184)",
                                                    pointBorderColor: "rgb(67, 78, 184)",
                                                    pointBackgroundColor: "rgb(67, 78, 184)",
                                                    pointHoverBackgroundColor: "rgb(67, 78, 184)",
                                                    pointHoverBorderColor: "rgb(67, 78, 184)",
                                                    pointHoverRadius: 10,
                                                    pointHoverBorderWidth: 1,
                                                    backgroundColor: "rgb(67, 78, 184)",
                                                    pointRadius: 3,
                                                    fill: false,
                                                    borderWidth: 0,

                                                    data: [100, 120, 150, 170, 180, 170, 160]
                                                }]
                                            },
                                            options: {
                                                legend: {
                                                    position: "top"
                                                },
                                                scales: {
                                                    yAxes: [{
                                                        ticks: {
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold",
                                                            beginAtZero: true,
                                                            maxTicksLimit: 5,
                                                            padding: 20
                                                        },
                                                        gridLines: {
                                                            drawTicks: false,
                                                            display: false
                                                        }
                                                    }],
                                                    xAxes: [{
                                                        gridLines: {
                                                            zeroLineColor: "transparent"
                                                        },
                                                        ticks: {
                                                            padding: 20,
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold"
                                                        }
                                                    }]
                                                }
                                            }
                                        });

                                    </script>

                                </canvas>
                            </div>
                            <div class="grafico-Dois">
                                <div class="title">titulo do grafico</div>
                                <canvas id="myChart-2" class="canvas">

                                    <script>
                                        var ctx = document.getElementById('myChart-2').getContext("2d")
                                        var myChart2 = new Chart(ctx, {
                                            type: 'line',
                                            data: {
                                                labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL"],
                                                datasets: [{
                                                    label: "Data",
                                                    fontColor:'#fff',
                                                    borderColor: "rgb(230, 134, 34)",
                                                    pointBorderColor: "rgb(230, 134, 34)",
                                                    pointBackgroundColor: "rgb(230, 134, 34)",
                                                    pointHoverBackgroundColor: "rgb(230, 134, 34)",
                                                    pointHoverBorderColor: "rgb(230, 134, 34)",
                                                    pointHoverRadius: 10,
                                                    pointHoverBorderWidth: 1,
                                                    backgroundColor: "rgb(230, 134, 34)",
                                                    pointRadius: 3,
                                                    fill: false,
                                                    borderWidth: 0,

                                                    data: [100, 120, 150, 170, 180, 170, 160]
                                                }]
                                            },
                                            options: {
                                                legend: {
                                                    position: "top"
                                                },
                                                scales: {
                                                    yAxes: [{
                                                        ticks: {
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold",
                                                            beginAtZero: true,
                                                            maxTicksLimit: 5,
                                                            padding: 20
                                                        },
                                                        gridLines: {
                                                            drawTicks: false,
                                                            display: false
                                                        }
                                                    }],
                                                    xAxes: [{
                                                        gridLines: {
                                                            zeroLineColor: "transparent"
                                                        },
                                                        ticks: {
                                                            padding: 20,
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold"
                                                        }
                                                    }]
                                                }
                                            }
                                        });

                                    </script>

                                </canvas>
                            </div>
                        </li>
                        <li class="grafico-tab">
                            <table class="circle">
                                <tr>
                                    <th class="circle-op">

                                        <canvas id="grafico3" width="" height="80">

                                            <script>
                                                let myChart3 = new Chart(document.getElementById("grafico3"), {
                                                    type: 'doughnut',
                                                    data: {
                                                        labels: ['concluido', 'não concluido'],
                                                        datasets: [{
                                                            label: 'DS',
                                                            backgroundColor: ['#7C0A0F', '#E5AD1D'],
                                                            borderColor: 'rgb(0,0,0)',
                                                            defaultFontSize: 12,
                                                            borderWidth: 0,
                                                            titleAlign: 'left',
                                                            data: [55, 45]

                                                        }]
                                                    },



                                                    // Configuration options go here
                                                    options: {
                                                        legend: {
                                                            position: 'right'
                                                        },
                                                    }
                                                });

                                            </script>

                                        </canvas>

                                    </th>
                                    <th class="circle-op" style="margin-left: 2rem">

                                        <canvas id="grafico4" width="" height="100">

                                            <script>
                                                let myChart4 = new Chart(document.getElementById("grafico4"), {
                                                    type: 'doughnut',
                                                    data: {
                                                        labels: ['concluido', 'não concluido'],
                                                        datasets: [{
                                                            label: 'DS',
                                                            backgroundColor: ['#7C0A0F', '#E5AD1D'],
                                                            borderColor: 'rgb(0,0,0)',
                                                            defaultFontSize: 12,
                                                            borderWidth: 0,
                                                            titleAlign: 'left',
                                                            data: [70, 30]

                                                        }]
                                                    },



                                                    // Configuration options go here
                                                    options: {
                                                        legend: {
                                                            position: 'right'
                                                        },
                                                    }
                                                });

                                            </script>

                                        </canvas></th>
                                </tr>
                            </table>
                            <div class="grafico-Ulti">
                                <div class="title">Titulo do Grafico</div>
                                <canvas id="myChart-5" class="canvas">

                                    <script>
                                        var ctx = document.getElementById('myChart-5').getContext("2d")
                                        var myChart5 = new Chart(ctx, {
                                            type: 'line',
                                            data: {
                                                labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL"],
                                                datasets: [{
                                                    label: "Data",
                                                    borderColor: "rgb(30, 221, 203)",
                                                    pointBorderColor: "rgb(30, 221, 203)",
                                                    pointBackgroundColor: "rgb(30, 221, 203)",
                                                    pointHoverBackgroundColor: "rgb(30, 221, 203)",
                                                    pointHoverBorderColor: "rgb(30, 221, 203)",
                                                    pointHoverRadius: 10,
                                                    pointHoverBorderWidth: 1,
                                                    backgroundColor: "rgb(30, 221, 203)",
                                                    pointRadius: 3,
                                                    fill: false,
                                                    borderWidth: 0,

                                                    data: [100, 120, 150, 170, 180, 170, 160]
                                                }]
                                            },
                                            options: {
                                                legend: {
                                                    position: "top"
                                                },
                                                scales: {
                                                    yAxes: [{
                                                        ticks: {
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold",
                                                            beginAtZero: true,
                                                            maxTicksLimit: 5,
                                                            padding: 20
                                                        },
                                                        gridLines: {
                                                            drawTicks: false,
                                                            display: false
                                                        }
                                                    }],
                                                    xAxes: [{
                                                        gridLines: {
                                                            zeroLineColor: "transparent"
                                                        },
                                                        ticks: {
                                                            padding: 20,
                                                            fontColor: "rgba(0,0,0,0.5)",
                                                            fontStyle: "bold"
                                                        }
                                                    }]
                                                }
                                            }
                                        });

                                    </script>

                                </canvas>

                            </div>

                        </li>

                    </ul>
                </section>

            </div>

        </div>

    </main>
</body>

</html>
