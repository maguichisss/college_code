/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
PROGRAMA QUE DICE CUENTA PILDORAS CON UN BUCLE FOR
USANDO SENTENCIA CONTINUE
Creado por: Mauricio Garc�s
Fecha de creacion: 11-11-10
/*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
#include<stdio.h>
#include<stdlib.h>
main()
{
    int sobrante, botella, pildora, tam_bot;
    char cont;
    printf("Introduzca la cantidad inicial de pildoras: ");
    scanf("%d",&pildora);
    printf("Introduzca el numero de pildoras por botella: ");
    scanf("%d",&tam_bot);
    if(tam_bot < 1)
        tam_bot = 1;
    botella = 0;
    for(sobrante = pildora - tam_bot; sobrante >= 0; sobrante -= tam_bot)
        {
            botella++;
            if(botella % 100 != 0)
                continue;
            printf("\n%d botellas llenas. Continuar? (Y/N): ",botella);
            scanf("\n\n%c",&cont);
            if(cont == 'N' || cont == 'n')
                    break;
        }
    if(sobrante < 0)
        sobrante += tam_bot;
    printf("\n\nCantidad inicial de pildoras: %d\n",pildora);
    printf("\n\nNumero de botellas llenadas: %d\n",botella);
    printf("\n\nNumero de pildoras sobrante: %d\n",sobrante);
    system("pause");
}
