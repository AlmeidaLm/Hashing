import csv
import pandas as pd
import matplotlib.pyplot as plt
import os.path

try:
    pasta = 'C:\\trabHash'
except:
    print('Pasta não encontrada')
try:
    arquivos_csv = [arquivo for arquivo in os.listdir(pasta) if arquivo.endswith('.csv')]
except:
    print('Pasta sem arquivos gerados!!!')
# Itera sobre cada arquivo CSV na pasta
for arquivo in arquivos_csv:
    # Caminho completo para o arquivo
    caminho_arquivo = os.path.join(pasta, arquivo)
    df = pd.read_csv(caminho_arquivo, header=None)
    segunda_coluna = df.iloc[:, 1]
    z = 0
    quantidade = []
    # Itera sobre as linhas do DataFrame
    for index, row in df.iterrows():
    #primeiro_elemento = row.iloc[0]  # Acessa o primeiro elemento da linha (primeira coluna)
        segundo_elemento = row.iloc[1] #Acessa o segundo elemento da linha(segunda coluna)
        #coluna.append(primeiro_elemento)
        quantidade.append(segundo_elemento)
        z = z+1
    # Plota o histograma
    plt.hist(quantidade,bins=z) # O parâmetro "bins" define o número de barras no histograma
    plt.xlabel('Tamanho da tabela')
    plt.ylabel('Frequência')
    plt.title('Histograma')
    plt.show()

