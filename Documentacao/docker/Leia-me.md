

1. deve start o banco smanager que esta disponivel no docker:
   comando: **docker-compose -f stack.yml .**

2. start aplicacao **eureka** 

3. start **server-config** para disponibilizar as configuracoes.

4. start aplicacao **Produto** para persistencia do dadaos.

5. start aplicacao **Compra** para consumir os servico.