from matplotlib import pyplot as plt

years = [1950, 1960, 1970, 1980, 1990, 2000, 2010, 2020]
gdp = [300.2, 543.3, 1075.9, 2862.5, 5979.6, 10289.7, 14958.3, 13608.6]

# create a line chart, years on x-axis, gdp(pib) on y-axis
plt.plot(years, gdp, color='green', marker='o', linestyle='solid')

#add a title
plt.title("Gdp Nominal")

#adiciona um selo no eixo y
plt.ylabel('Bilhões de $')
plt.show()