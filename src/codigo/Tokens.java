package codigo;

public enum Tokens {
    ST,			//	START	Inicia el proceso	 
    CL,			//	CHECKLEVEL	Revisa el nivel de los tanques	 
    AL,			//	ALERT	Alerta del sistema 	 
    CH,			//	CHECKHUM	Revisa la humedad en la tierra	
    CPH,		//	CHECKPH	Revisa el pH en la tierra	 
    NW,			//	NEEDWATER	Determina si se necesita regar	 
    WP,			//	WATERPLANTS	Riega las plantas 	 
    FT,			//	FILLTANKS	Llenado de tanques 	 
    EN,			//	END	Termina el proceso	 
    ep,			//	b/	Espacio en blanco
    at,			//	*	Asterisco
    ms,			//	+	Mas
    ptc,		//	;	Punto y coma
    et,			//	    Enter
    ig,			//	=	Igual
    cm,			//	,				Coma
    pj,			//	%	Porcentaje
    mai,		//	>=	Mayor igual
    mei,		//	<=	Menor o igual
    df,			//	=!	Diferente de
    sw,			//	sw	Switch de apagado o encendido 
    vl,			//	vl	Valor nivel agua
    h,			//	h	Valor humedad
    ph,			//	ph	Valor ph
    If,			//	if	Condicional si
    Else,		// 	else	Condicional si no
    or,			//	or	o
    pa,			//	(	Paréntesis que abre    
    pc,			//	)	Paréntesis que cierra 
    and,		//	&&	And 
    num,		//	1, 2, 3…100	Porcentaje del nivel de agua
    bi,			//	0 o 1 Estado 
    ERROR       // Token si falla en los demas
}
