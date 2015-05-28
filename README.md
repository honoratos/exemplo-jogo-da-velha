# Exemplo de Jogo da Velha para Android

### Resumo do resumo resumido ^^

Neste exemplo foram criados botões no arquivo de layout. Cada botão contem as propriedade tag e onClick além de outras.
Todos botões tem peso 1(android:layout_weight="1"). Com isso os botões ocupam toda a tela de forma uniforme.

Os métodos verificam se existe um vencedor a cada jogada. Caso encontre um vencedor, o método muda a cor da linha do resultado e mostra uma mensagem(mensagem Toast) com o vencedor.

Usamos um array bidimensional para "guardar" os resultados possíveis. O método "vencedor()" percorre esse array e se encontrar resultados iguais ele "chama" o método "mensagemToast()" passando como parametro o vencedor.

#### Foi abordado

* LinearLayout
* Button
* TextView
* Toast

#### Tipos de variáveis

* String
* Int
* Boolean
* Array
