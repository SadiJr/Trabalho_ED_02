package hash;

import jdk.nashorn.internal.runtime.arrays.NumericElements;

public class Hash {
	private int[][] hash;
	private int tamanho;
	private int modulo;
	private int numElem;
	private int primeiroVazio;

	public Hash(int modulo, int tamanho) throws Exception {
		if (modulo * 3 >= tamanho) {
			throw new Exception("O módulo deve ser, no mínimo, 3 vezes menor"
					+ " que o tamanho total do Hash");
		}
		this.modulo = modulo;
		this.tamanho = tamanho;
		primeiroVazio = modulo;
		numElem = 0;
		hash = new int[tamanho][2];
		for (int i = 0; i < modulo; i++) {
			hash[i][1] = -2;
		}
		for (int i = modulo; i < tamanho; i++) {
			hash[i][1] = i + 1;
		}
	}

	public void insere(int elemento) throws Exception{
		if (numElem < tamanho){
			int indice = elemento % modulo;
			if (hash[indice][1] == -2) {
				hash[indice][0] = elemento;
				hash[indice][1] = -1;
				numElem++;
			} else if (hash[indice][1] == -1) {
				int novoIndice = primeiroVazio;
				primeiroVazio = hash[novoIndice][1];
				hash[novoIndice][0] = elemento;
				hash[novoIndice][1] = -1;
				hash[indice][1] = novoIndice;
				numElem++;
			} else {
				int novoIndice = primeiroVazio;
				primeiroVazio = hash[novoIndice][1];
				hash[novoIndice][0] = elemento;
				hash[novoIndice][1] = -1;
				boolean achei = false;
				numElem++;
				while (!achei) {
					if (hash[indice][1] == -1) {
						achei = true;
						hash[indice][1] = novoIndice;
					} else {
						indice = hash[indice][1];
					}
				}
			}
		}else{
			throw new Exception("O Hash está cheio!");
		}

	}

	public boolean busca(int elemento) throws Exception {
		if (numElem == 0) {
			throw new Exception("Hash Vazio");
		}
		int indice = elemento % modulo;
		boolean achei = true;
		while (achei) {
			if (hash[indice][1] == -2) {
				achei = false;
			} else if (hash[indice][1] == -1) {
				if (hash[indice][0] == elemento) {
					return achei;
				} else {
					achei = false;
				}
			} else if (hash[indice][0] == elemento) {
				return achei;
			} else {
				indice = hash[indice][1];
			}
		}
		return achei;
	}

	public void exclui(int elemento) throws Exception {
		if (numElem == 0) {
			throw new Exception("Hash Vazio");
		}
		int indice = elemento % modulo;
		if (hash[indice][1] == -2) {
			throw new Exception("Não existe nenhum elemento inserido neste módulo");
		}
		if (hash[indice][0] == elemento) {
			if (hash[indice][1] == -1) {
				hash[indice][1] = -2;
				numElem--;
			} else {
				int proximo = hash[indice][1];
				hash[indice][0] = hash[proximo][0];
				hash[indice][1] = hash[proximo][1];
				hash[proximo][1] = primeiroVazio;
				primeiroVazio = proximo;
				numElem--;
			}
		} else {
			boolean excluido = false;
			int anterior = indice;
			int proximo = hash[indice][1];
			while (!excluido) {
				if (hash[proximo][1] == -1) {
					if (hash[proximo][0] == elemento) {
						hash[anterior][1] = hash[proximo][1];
						hash[proximo][1] = primeiroVazio;
						primeiroVazio = proximo;
						numElem--;
						excluido = true;
					} else {
						throw new Exception("O elemento " + elemento + " não se encontra no Hash.");
					}

				} else if (hash[proximo][0] == elemento) {
					hash[anterior][1] = hash[proximo][1];
					hash[proximo][1] = primeiroVazio;
					primeiroVazio = proximo;
					numElem--;
					excluido = true;
				} else {
					anterior = proximo;
					proximo = hash[proximo][1];
				}
			}
		}

	}

	public void listarTodos() {
		for (int i = 0; i < this.tamanho; i++) {
			System.out.println("Índice: "+ i + " / Dado: " + hash[i][0] + " / Próximo: " + hash[i][1]);
			//System.out.println("Proximo: " + hash[i][1]);
		}
	}

}
