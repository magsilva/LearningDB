public class DivisionWizard
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		method1();
	}

	public static void method1()
	{
		/*
		 * String relationA = "SPJ"; String parameterA = "sno"; String relationB = "P"; String
		 * parameterB = "pno"; String conditionB = "weight > 70";
		 */
		//String relationA = "(SELECT Aluno.nusp, Turma.sigla FROM Aluno, Matricula, Turma WHERE Aluno.nusp = Matricula.nusp AND Matricula.codigoturma = Turma.codigo)";
		//String parameterA = "nusp";

		//String relationB = "(SELECT Professor.nome, Turma.sigla FROM Professor, Ministra, Turma WHERE Professor.nnfuncional = Ministra.nnfuncprof AND Ministra.codigo = Turma.codigo)";
		//String parameterB = "sigla";
		//String conditionB = "globalB.nome = 'Ari'";
		
		
		String relationA = "Aluno";
		String parameterA = "nusp";

		String relationB = "Matricula";
		String parameterB = "*";
		String parameterC = "codigoturma";
		String conditionB = "globalB.codigoturma in (select m.codigo from Ministra as m, Professor as p where p.nome='Ari' and p.nnfuncional=m.nnfuncprof)";
		
		StringBuffer cmd = new StringBuffer();
		cmd.append("\nSELECT");

		cmd.append("\n\tDISTINCT ");
		cmd.append(parameterA);

		cmd.append("\nFROM");
		cmd.append("\n\t").append(relationA);
		cmd.append(" AS globalA");

		cmd.append("\nWHERE");
		cmd.append("\n\tNOT EXISTS (");

		cmd.append("\n\t\tSELECT");
		cmd.append("\n\t\t\t").append(parameterB);
		cmd.append("\n\t\tFROM");
		cmd.append("\n\t\t\t").append(relationB).append(" AS globalB");

		cmd.append("\n\t\tWHERE");
		cmd.append("\n\t\t\t").append(conditionB);
		cmd.append(" AND NOT EXISTS (");

		cmd.append("\n\t\t\tSELECT");
		cmd.append("\n\t\t\t\t*");

		cmd.append("\n\t\t\tFROM");
		cmd.append("\n\t\t\t\t").append(relationA);
		cmd.append(" AS localA NATURAL JOIN globalA");
		cmd.append("\n\t\t\tWHERE");
		cmd.append("\n\t\t\t\tlocalA.").append(parameterA).append(" = globalB.").append(parameterA);
		cmd.append("\n\t\t)");
		cmd.append("\n\t);");

		System.out.println(cmd);
	}

	public static void method2()
	{
		String relationA = "Aluno";
		String parameterA = "nusp";

		String relationB = "Matricula";
		String parameterB = "*";
		String parameterC = "codigoturma";
		String conditionB = "globalB.codigoturma in (select m.codigo from Ministra as m, Professor as p where p.nome='Ari' and p.nnfuncional=m.nnfuncprof)";

		StringBuffer cmd = new StringBuffer();
		cmd.append("\nSELECT");

		cmd.append("\n\tDISTINCT ");
		cmd.append("globalA.").append(parameterA);

		cmd.append("\nFROM");
		cmd.append("\n\t").append(relationA);
		cmd.append(" AS globalA");

		cmd.append("\nWHERE");
		cmd.append("\n\tNOT EXISTS (");

		cmd.append("\n\t\tSELECT");
		cmd.append("\n\t\t\t").append(parameterB);
		cmd.append("\n\t\tFROM");
		cmd.append("\n\t\t\t").append(relationB).append(" AS globalB");

		cmd.append("\n\t\tWHERE");
		cmd.append("\n\t\t\t").append(conditionB);
		cmd.append("\n\t\t\tAND");
		cmd.append("\n\t\t\tNOT EXISTS (");

		cmd.append("\n\t\t\t\tSELECT");
		cmd.append("\n\t\t\t\t\t*");

		cmd.append("\n\t\t\t\tFROM");
		cmd.append("\n\t\t\t\t\t").append(relationB).append(" AS localB");
		cmd.append("\n\t\t\t\tWHERE");
		cmd.append("\n\t\t\t\t\tlocalB.").append(parameterA).append(" = globalA.").append(parameterA);
		cmd.append("\n\t\t\t\t\tAND");
		cmd.append("\n\t\t\t\t\tlocalB.").append(parameterC).append(" = globalB.").append(parameterC);
		cmd.append("\n\t\t\t)");
		cmd.append("\n\t\t);");

		System.out.println(cmd);
	}
}
