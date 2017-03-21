import java.io.*;
import java.util.*;

public class Principal {

	static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
	static ArrayList<Pesquisa> pesquisas;
	static Administrador adm_logado = null;
	static ArrayList<Resposta> respostas = new ArrayList<Resposta>();
	
	public static void main(String[] args) {
		Administrador admin;
		Pergunta pergunta = null;
		Pesquisa pesquisa;
		Alternativa alternativa;
		String temp_a, temp_b;
		Resposta resposta;
		Scanner scan = new Scanner(System.in);
		int cont, cont_b, cont_c, qtd, codigo, senha, menu, menu_2, menu_3, menu_4 = 0, temp = 1, menu_e;
		String nome, str;
		
		admin = new Administrador(5555, "Lucas", 123);
		administradores.add(admin);
		
		admin = new Administrador(5678, "Vinicius", 321);
		administradores.add(admin);
		
		do {
			System.out.print("Código Administrador = ");
			codigo = (Integer.parseInt(scan.nextLine()));
			System.out.print("Senha = ");
			senha = (Integer.parseInt(scan.nextLine()));
			if (!login(codigo, senha)) {
				System.out.println("Usuário ou senha incorretos. Tente novamente!");
			}
		} while ( adm_logado == null );
		
		System.out.println("Bem vindo(a), " + adm_logado.getUsuario() + "!");
		
		do {
		
			System.out.println("Escolha uma opção:\n"
					+ "1 - Cadastrar Pesquisa"
					+ "\n2 - Listar Pesquisas"
					+ "\n3 - Sair");
			menu = (Integer.parseInt(scan.nextLine()));
			
			if (menu == 1) {
				
				System.out.println("Digite o nome da pesquisa:");
				temp_a = scan.nextLine();
				pesquisa = new Pesquisa(temp_a);
				pesquisas.add(pesquisa);
				salvar();
				System.out.println("Digite a pergunta: ");
				temp_a = scan.nextLine();
				pergunta = new Pergunta(temp_a);
				
				for(cont = 0 ; cont < 3; cont++){
					System.out.println("Digite a " + (cont + 1) + "ª alternativa: ");
					temp_a = scan.nextLine();
					alternativa = new Alternativa(temp_a);
					pergunta.addAlternativa(alternativa);
				}
				
				do{
						System.out.println("Deseja adicionar mais uma alternativa?\n"
								+ "1- Sim\n"
								+ "2- Não");
						menu_4 = (Integer.parseInt(scan.nextLine()));
						if(menu_4 == 1){
							System.out.println("Digite a " + (cont + 1) + "ª alternativa: ");
							temp_a = scan.nextLine();
							alternativa = new Alternativa(temp_a);
							pergunta.addAlternativa(alternativa);
							cont++;
						}
				}while(menu_4 == 1);
					
				pesquisa.addPergunta(pergunta);
				salvar();
				
			} else if (menu == 2) {
				// XXX LISTAR PESQUISAS
				for(cont = 0; cont < pesquisas.size(); cont++){
					pesquisa = pesquisas.get(cont);
					System.out.println(cont  + " > " + pesquisa.getNome());
				}
				
				System.out.println(cont + " > Voltar ");
				
				do {
					System.out.println("Digite o número da pesquisa para selecioná-la:");
					menu_2 = (Integer.parseInt(scan.nextLine()));
				} while(menu_2 < 0 || menu_2 >= pesquisas.size()+1);
				
				pesquisa = pesquisas.get(menu_2);
				
				if (menu_2 != cont) {
					
					do {
						System.out.println("O que você quer fazer?\n1 - Iniciar a Pesquisa\n2 - Alterar Perguntas\n3 - Estatísticas\n4 - Voltar");
						menu_3 = (Integer.parseInt(scan.nextLine()));
					} while (menu_3 < 1 && menu_3 > 4);
					
					if (menu_3 == 1){
						
						System.out.println("A pesquisa será iniciada: \n\n");
						
						for(cont = 0; cont < pesquisa.getPerguntas().size(); cont++){
							pergunta = pesquisa.getPerguntas().get(cont);
							System.out.println(pergunta.getPergunta());
							for(cont_b = 0; cont_b < pergunta.getAlternativas().size(); cont_b++){
								alternativa = pergunta.getAlternativas().get(cont_b);
								System.out.println(cont_b + ") " + alternativa.getAlternativa());
							}
							
							do {
								System.out.println("Alternativa:");
								try{
									temp = (Integer.parseInt(scan.nextLine()));
								}catch(Exception e){
									temp = -1;
								}
							}while(temp < 0 || temp > cont_b);
							
							pergunta.addResposta(temp);
						}
						
						
					} else if (menu_3 == 2) {

						for(cont = 0; cont < pesquisa.getPerguntas().size(); cont++){
							pergunta = pesquisa.getPerguntas().get(cont);
							System.out.println(cont + " > " + pergunta.getPergunta());
						}
						
						System.out.println(cont + "> Adicionar mais uma pergunta a essa pesquisa");
						
						do {
							System.out.println("Escolha qual pergunta quer alterar:");
							temp = (Integer.parseInt(scan.nextLine()));
						}while(temp < 0 || temp > cont);
						
						if(temp < cont){
							pergunta = pesquisa.getPerguntas().get(temp);
							System.out.println("Digite o novo texto da pergunta:");
							str = scan.nextLine();
						
							pergunta.setPergunta(str);
							salvar();
						} else {
							System.out.println("Digite uma nova pergunta = ");
							str = scan.nextLine();
							pergunta = new Pergunta(str);
							
							do{
									System.out.println("Deseja adicionar mais uma alternativa?\n"
											+ "1- Sim\n"
											+ "2- Não");
									menu_4 = (Integer.parseInt(scan.nextLine()));
									if(menu_4 == 1){
										System.out.println("Digite a " + (cont + 1) + "ª alternativa: ");
										temp_a = scan.nextLine();
										alternativa = new Alternativa(temp_a);
										pergunta.addAlternativa(alternativa);
										cont++;
									}
							}while(menu_4 == 1);
								
							pesquisa.addPergunta(pergunta);
							salvar();
						}
					} else if (menu_3 == 3) {				

						temp = pesquisa.getPerguntas().size(); 
						
						if (temp == 0) {
								System.out.println("Nenhuma resposta para gerar as estatísticas da pesquisa.");
						} else {
							
								for(cont = 0; cont < pesquisa.getPerguntas().size(); cont++){
									pergunta = pesquisa.getPerguntas().get(cont);
									System.out.println(pergunta.getPergunta());
									
										
										for(cont_b = 0; cont_b < pergunta.getAlternativas().size();cont_b++){
											alternativa = pergunta.getAlternativas().get(cont_b);
											
											if (pergunta.getRespostas().size() > 0) {
											
											qtd = 0;
											for(cont_c = 0; cont_c < pergunta.getRespostas().size(); cont_c++){
												temp = pergunta.getRespostas().get(cont_c);
												if (temp == cont_b) {
													qtd++;
												}
											}
											
											temp = (qtd * 100) / pergunta.getRespostas().size();
											
											System.out.println(alternativa.getAlternativa() + " - " + (temp) + "%");
											
											} else {
												System.out.println(alternativa.getAlternativa());
											}
										}
									
								}
								
								
						}
							
					}
					
				}
				
			}
			
			// Caso digite errado
			else if( menu > 3 || menu < 1) {
				System.out.println("Opção inválida!");
			}
			
		} while ( menu != 3);
		
	}
	
	public static boolean login(int cod, int senha){
		int cont;
		Administrador adm;
		for(cont = 0; cont < administradores.size(); cont++){
			adm = administradores.get(cont);
			if (adm.getCodigo() == cod && adm.getSenha() == senha) {
				adm_logado = adm;
				carregar();
				return true;
			}
		}
		return false;
	}
	
	public static void salvar(){
		ObjectOutputStream conteudo;
		conteudo = null;
		try {
			conteudo= new ObjectOutputStream(new FileOutputStream("c:\\temp\\data.dad"));
			conteudo.writeObject(pesquisas);
		} catch (FileNotFoundException e) {
			System.out.println("Erro = Arquivo não encontrado!");
		} catch (IOException e) {
			System.out.println("Erro " + e);
			e.printStackTrace();
		} finally {
			if (conteudo != null)
				try {
					conteudo.close();
				} catch (IOException e) {
					System.out.println("Erro " + e);
					e.printStackTrace();
				}
		}
	}
	
	public static void carregar(){
		ObjectInputStream conteudo;
		conteudo = null;
		try {
			conteudo = new ObjectInputStream(new FileInputStream("c:\\temp\\data.dad"));
			try {
				pesquisas = (ArrayList<Pesquisa>)conteudo.readObject();
			} catch (ClassNotFoundException e) {
				pesquisas = new ArrayList<Pesquisa>();
			}
		} catch (FileNotFoundException e) {
			pesquisas = new ArrayList<Pesquisa>();
		} catch (IOException e) {
			pesquisas = new ArrayList<Pesquisa>();
		} finally {
			if (conteudo != null)
				try {
					conteudo.close();
				} catch (IOException e) {
					//
				}
		}
	}
	
}
