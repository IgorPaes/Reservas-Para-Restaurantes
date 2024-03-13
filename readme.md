# Funcionalidades do Sistema de reserva para restaurantes
1. Cadastro de Cliente; 
2. Login de Cliente; 
3. Criar Reserva; 
4. Cancelar Reserva; 
5. Pesquisar Restaurantes; 
6. Editar Reserva; 
	- Editar data ou horário; 
 	- Editar Mesa; 
 	- Editar número de pessoas; 

7. Gerenciar Reserva (Funcionário) 
 	- Confirmar a reserva; 
 	- Recusar a reserva; 
 	- Cancelar a reserva;

**Modelo de entidade e Relacionamento**
![Modelo de entidade e relacionamento](/assets/imgs-projeto/MER-restaurante.png)



# Construção dos protótipos de alta fidelidade.
1. Site(Landing Page); 
	- Nesta tela da Landing Page, o cliente (que vai fazer a reserva) poderá fazer o seu login e seu cadastro. Assim que ele(a) logar, poderá escolher o seu restaurante preferido para fazer a reserva e consultar as informações, como por exemplo, se o restaurante está aberto ou fechado, telefone para contato e endereço.
**Landing Page**
![Landing Page](/assets/imgs-projeto/Site(Landing%20Page).png)

2. Login; 
	- Na tela de login, você deve preencher os campos com o login e senha. Caso você esqueça sua senha, clique no botão 'Esqueci minha senha'. Caso não tenha cadastro, clique no botão 'Cadastrar agora'.
**Login**
![Login](/assets/imgs-projeto/Login.png)
	
3. Cadastro; 
	- Na tela de cadastro, você precisa preencher os campos com seu nome, e-mail e senha. Caso queira voltar para o login, basta clicar em 'Fazer login'. Quando terminar o cadastro, você deve acessar a tela de login para fazer o login em sua conta.
**Cadastro**
![Cadastro](/assets/imgs-projeto/Cadastro.png)

4. Criar Reserva; 
	- Após fazer login e escolher seu restaurante favorito, você pode clicar no botão 'Faça sua reserva' e será direcionado para criar a sua reserva. Para isso, basta preencher os campos como apelido, telefone, CPF, datas, horários, quantidade de pessoas e adicionar um comentário (à sua escolha). No próximo passo, você pode confirmar ou cancelar sua reserva, e em seguida aparecerá um alerta para confirmar ou editar sua reserva.
**Criar Reserva**
![Criar Reserva](/assets/imgs-projeto/Criar-Reserva.png)
**Alerta-Confirmar**
![Alerta-Confirmar](/assets/imgs-projeto/Alerta-Confirmar-Reserva.png)

5. Minhas Reservas(Cliente); 	
	- Depois de confirmar sua reserva, você será direcionado para outra tela. Ao clicar em 'Minhas reservas', você pode consultar todas as suas reservas e filtrá-las pelo ID ou pela data. Você também pode cancelar sua reserva clicando no botão 'Cancelar minha reserva' ou editar sua reserva clicando no botão cinza com um ícone de um lápis.
**Minhas Reservas**
![Minhas Reservas](/assets/imgs-projeto/Minhas-reservas.png)

6. Histórico De Reservas(Cliente);
	- Ao clicar na aba ao lado em 'Histórico de Reservas', você pode ver todas as reservas que você mesmo fez nos seus restaurantes favoritos.
**Histórico De Reservas**
![Histórico De Reservas](/assets/imgs-projeto/Historico-reservas-1.png)

7. Reservas pendentes(Restaurante);
	- Ao clicar na aba 'Reservas Pendentes', o restaurante pode cancelar a reserva caso a mesa esteja ocupada (clicando no botão 'Cancelar Reserva'). Ele também pode aprovar a reserva, confirmando com o cliente que está tudo ok (clicando no botão 'Aprovar Reserva'). Além disso, o restaurante pode editar a reserva (clicando no botão cinza com um ícone de lápis). Lembre-se de que o restaurante também pode filtrar as reservas pelo ID e pela data.
**Reservas pendentes**
![Reservas pendentes](/assets/imgs-projeto/Reservas-pendentes.png)

8. Reservas em andamento(Restaurante);
	- Na aba 'Reservas em andamento', o restaurante pode visualizar todas as reservas que foram aprovadas, podendo 'Cancelar Reserva' (clicando no botão 'Cancelar Reserva') e 'Editar Reserva' (clicando no botão 'Editar Reserva').
**Reservas em andamento**
![Reservas em andamento](/assets/imgs-projeto/Reservas-andamento.png)

8. Histórico de reservas(Restaurante);
	- Na aba 'Histórico de Reservas' ficam armazenadas todas as reservas aceitas ou negadas, juntamente com as informações respectivas a elas.
**Histórico de reservas**
![Histórico de reservas](/assets/imgs-projeto/Historico-reservas-2.png)

**Link do Figma:** https://www.figma.com/file/hVkB0Zc0hDUNXIzEAOqpwR/Restaurante?type=design&node-id=0%3A1&mode=design&t=5v7xMMMp1OmOOmRq-1