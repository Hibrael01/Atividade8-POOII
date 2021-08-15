import { Curso } from "../curso/curso.model";

export class Aluno{
    idaluno: number;
    nome: String;
    sexo: String;
    dt_nasc: Date;
    cursos: Curso[]
}