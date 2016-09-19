# assessement-javaweb
Assessement do bloco de desenvolvimento Java.

TAREFA
------------------------------------------------------------------------------
Você deve construir uma aplicação Java Web dividida em três camadas, modelo, visão e controle, utilizando Spring Web MVC para construí-la, JSP para a interface com o usuário, JPA/Hibernate para modelagem objeto-relacional do banco de dados.

Sua aplicação deve possibilitar o cadastro e autenticação de usuários. Este usuário terá os seguintes campos de formulário:

    Nome
    E-mail
    Senha

E o formulário deve possuir um botão Salvar.

Quando o botão Salvar for acionado, sua aplicação deve gravar estas informações em banco de dados.

A seguir, a aplicação deve exibir as informações de nome e e-mail do usuário numa página JSP de mensagem de sucesso no cadastro, bem como um link Login.

Quando a opção de Login for selecionada, a aplicação deve exibir um formulário solicitando e-mail e senha do usuário, com um botão Realizar Login. A ação Realizar Login deve buscar o e-mail informado na base de dados e, caso ele exista, comparar a senha informada com a senha registrada. Caso os dados estejam corretos, uma mensagem deve ser exibida, informando que o usuário está autenticado no sistema. Do contrário, o formulário de login deve ser reexibido informando que os dados estão incorretos.

Uma vez que o usuário esteja autenticado, deve ser apresentado ao usuário opções para listagem, cadastro, detalhamento, edição e exclusão de objetos da classe Livro, possuindo:

    Título
    Autor
    Editora
    Ano de Lançamento

Os objetos do tipo Livro devem ser armazenados em banco de dados, e sua aplicação deve ser configurada para gerenciá-lo, utilizando o Hibernate. Você pode criar classes auxiliares, como Autor e Editora, para enriquecer o trabalho.

Além disso, você deve mapear suas funcionalidades de cadastro de livros e de detalhamento de livros para web services de escrita (POST) e leitura (GET), respectivamente, para que possam ser consumidos por outras aplicações. Você pode construir uma aplicação Java para consumir este webservice e testá-lo.
------------------------------------------------------------------------------
