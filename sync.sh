#Functions as a sync program for APCS Workspace

git pull origin master
git mergetool
git add .
git status
read -e -p "Commit Name: " var
git commit -a -m "$var"
git push origin master
read -n1 -r -p "Press any key to continue..." key
exit
