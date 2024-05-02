read input
read output
find $input -type f -name "*.txt" | while read file;
   do
  fname=$(basename "$file")
  way="$output/$fname"
  
  if [ -f "$way" ]; then
    counter=1
    while [ -f "$way" ]; do
      new_fname="${fname%.*}_$counter.${fname##*.}"
      way="$output/$new_fname"
      ((counter+=1))
    done
  fi
  
  cp "$file" "$way"
done
