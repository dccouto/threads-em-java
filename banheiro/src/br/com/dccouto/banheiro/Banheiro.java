package br.com.dccouto.banheiro;

public class Banheiro {
	
	private boolean estaSujo = true;
	
	public void fazNumero1() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			
			System.out.println(nome + " entrando no banheiro");
			
			while(this.estaSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa rápida");
			
			this.estaSujo = true;
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");
		}
		
		
	}
	public void fazNumero2() {
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " batendo na porta");
		
		synchronized (this) {
			
			System.out.println(nome + " entrando no banheiro");
			
			while(this.estaSujo) {
				esperaLaFora(nome);
			}
			
			System.out.println(nome + " fazendo coisa demorada");
			
			this.estaSujo = true;
			
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(nome + " dando descarga");
			System.out.println(nome + " lavando as mãos");
			System.out.println(nome + " saindo do banheiro");
		}
		
	}
	
	private void esperaLaFora(String nome) {

	    System.out.println(nome + ", eca, banheiro está sujo");
	    try {
	        this.wait();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public void limpa() {

	    String nome = Thread.currentThread().getName();

	    System.out.println(nome + " batendo na porta");

	    synchronized (this) {

	        System.out.println(nome + " entrando no banheiro");

	        if (!this.estaSujo) {
	            System.out.println(nome + ", não está sujo, vou sair");
	            return;
	        }

	        System.out.println(nome + " limpando o banheiro");
	        this.estaSujo = false;

	        try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
	    }
	}
}
