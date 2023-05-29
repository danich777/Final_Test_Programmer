# Задания 1-5 Linux
## Задача 1
Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их. Просмотреть содержимое созданного файла. Переименовать файл, дав ему новое имя (Друзья человека).
```agsl
anton@anton:~$ cat > Домашние_животные
собаки
кошки
хомяки

anton@anton:~$ cat > Вьючные_животные
лошади
верблюды
ослы

anton@anton:~$ cat Домашние_животные Вьючные_животные > Друзья_человека
anton@anton:~$ cat Друзья_человека
собаки
кошки
хомяки
лошади
верблюды
ослы
```
## Задача 2
Создать директорию, переместить файл туда.
```agsl
anton@anton:~$ mkdir animals
anton@anton:~$ mv Друзья_человека animals
anton@anton:~$ cd animals
anton@anton:~/animals$ ls
Друзья_человека
```
## Задача 3
Подключить дополнительный репозиторий MySQL. Установить любой пакет из этого репозитория.
```agsl
anton@anton:~$ sudo apt-get update
anton@anton:~$ sudo apt-get install mysql-server
```
## Задача 4
Установить и удалить deb-пакет с помощью dpkg.
```agsl
anton@anton:~$ wget https://download.docker.com/linux/ubuntu/dists/jammy/pool/stable/arm64/docker-ce-cli_24.0.2-1~ubuntu.22.04~jammy_arm64.deb
anton@anton:~$ sudo dpkg -i docker-ce-cli_24.0.2-1~ubuntu.22.04~jammy_arm64.deb
anton@anton:~$ sudo dpkg -r docker-ce-cli
```
## Задача 5
Выложить историю команд в терминале ubuntu