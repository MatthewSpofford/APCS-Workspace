#Functions as a sync program

git pull origin master
git mergetool
git add .
git commit -a -m "new commit"
git push origin master
read -n1 -r -p "Press any key to continue..." key
exit
