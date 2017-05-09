#!/bin/bash
shopt -s expand_aliases
alias enquanto="java -classpath ../target/output/:../antlr-runtime-4.7.jar plp.enquanto.Principal"
FILES=resources/*.while
tmp=`mktemp`
tmpdiff=`mktemp`

function check_outputs {
	# $1: Arquivo de saida esperado
	# $2: Arquivo de saida
	# $3: Prefixo
	out=$1
	tmp=$2
	prefixo=$3

	diff $out $tmp &> $tmpdiff
	result=$?
	if [ $result == "0" ]; then
		echo -e "${prefixo}  - \e[32mOK\e[39m"
	else
		echo "${prefixo}  - Diferença na saída"
		echo -e "${prefixo}  - \e[31m`cat $tmpdiff`\e[39m"
	fi
}

function run_file {
	# $1: Código de retorno do enquanto
	# $2: Arquivo de saída esperado
	# $3: Arquivo de saida
	# $4: Prefixo string

	status=$1
	saidaesperada=$2
	saida=$3
	prefixo=$4

	if [ $status == "0" ]; then
		check_outputs $saidaesperada $saida "$prefixo"
	else
		echo "${prefixo}  - Erro na compilação"
		echo -e "${prefixo}  - \e[31m`cat $saida`\e[39m"
	fi
}
for f in $FILES
do
	basename=$(basename "$f")
	name="${basename%.*}"
	in="resources/${name}*.in"
	out=resources/${name}.out
	echo "Checking $name"
	echo "============="
	if compgen -G $in > /dev/null; then
		i=0
		for input in $in
		do
			let "i++"
			input_basename=$(basename "$input")
			input_name="${input_basename%.*}"
			echo "  Caso $i ($input_name): "
			enquanto $f < $input &> $tmp
			run_file $? "resources/${input_name}.out" $tmp "  "
		done
	else
		enquanto $f &> $tmp
		run_file $? $out $tmp ""
	fi
	echo ""
done
