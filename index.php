<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="style.css" />

    <script type="text/javascript" src="jquery-3.5.1.min.js"></script>

    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@500;700&family=Lobster&display=swap" rel="stylesheet" />
    <title>Repair - Home</title>
</head>

<body>
    <main>
        <form name="" method="post" action="">
        <section class="landing">
            <nav>
                <h1 id="logo">Vision</h1>
                <ul class="nav-links">
                    <li>Login</li>
                    <div class="caixa">
                        <div class="form">
                            <input type="text" name="email" autocomplete="off" required />
                            <label for="name" class="label-name">
                                <span class="content-name">Email</span>
                            </label>                                                     
                        </div>
                         <div class="form" style="margin-top:1vh;">
                            <input  type="password" name="senha" autocomplete="off" required />
                            <label for="text" class="label-name">
                                <span class="content-name">Senha</span>
                            </label>                                                     
                        </div>
                      <input type="submit" class="button" name="submit" value="Logar" />
                    

                    </div>
            
                </ul>

            </nav>
            <h2 class="big-text">Repair</h2>
        </section>
        </form>
    </main>
    
    <?php
				
				$user = @$_REQUEST['email'];
				$pass = @$_REQUEST['senha'];
				$submit = @$_REQUEST['submit'];
				
				/* Declaração das variáveis que possuem os usuarios e as senhas */
				$user1 = 'admrepair7@gmail.com';
				$pass1 = '123';
				
				$user2 = 'adm@repair';
				$pass2 = '123';
				
			
				if($submit){
					
					if($user == "" || $pass == ""){
						echo "<script:alert('Por favor, preencha todos os campos!');</script>";
					}
					
					else{
						if(($user == $user1 && $pass == $pass1) || ($user == $user2 && $pass == $pass2)){
							session_start();
							$_SESSION['usuario']=$user;
							$_SESSION['senha']=$pass;
							header("Location: adm.php");
						}
						else{
							echo "<script>alert('Usuário e/ou senha inválido(s), Tente novamente!');</script>";
						}
					}
				}
			?>
    <div class="intro">
        <div class="intro-text">
            <h1 class="hide">
                <span class="text">Tudo parece impossível</span>
            </h1>
            <h1 class="hide">
                <span class="text">Até que seja</span>
            </h1>
            <h1 class="hide">
                <span class="text">Feito.</span>
            </h1>
        </div>
    </div>


    <script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.5.1/gsap.min.js" integrity="sha512-IQLehpLoVS4fNzl7IfH8Iowfm5+RiMGtHykgZJl9AWMgqx0AmJ6cRWcB+GaGVtIsnC4voMfm8f2vwtY+6oPjpQ==" crossorigin="anonymous"></script>
    <script src="./app.js"></script>
</body>

</html>
