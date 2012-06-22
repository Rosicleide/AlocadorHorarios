package alocadorhorarios

import java.awt.Desktop.Action;

import alocadorhorarios.Departamento;

import com.grailsrocks.functionaltest.*

class DepartamentoFunctionalTests extends BrowserTestCase {
	void testLogin() {
		get('/login/auth')
		assertStatus 200
		
		form {
			j_username "joao"
			j_password "1234"
			click "submit"
		}
		assertContentContains "submit"
		assertStatus 200
	}
    
	void testList(){
		get('/departamento/list')
		assertContentContains "List"
		assertStatus 200
		
		get('/departamento/create')
		assertContentContains "Create"
		assertStatus 200
		
		form {
			nome "Exatas"
			cor "branco"
			click "create"
		}
		assertContentContains "Exatas"
		assertContentContains "branco"
		assertContentContains "created"
		assertStatus 200
		
		click "Edit"
		assertContentContains "Edit"
		assertStatus 200
		
		form {
			nome "dxu"
			cor "preto"
			click "_action_update"
		}
		
		assertContentContains "dxu"
		assertContentContains "preto"
		assertContentContains "updated"
		assertStatus 200
		
		click "Departamento List"
		assertContentContains "dxu"
		assertContentContains "preto"
		assertContentContains "List"
		assertStatus 200
		
		click "dxu"
		click "Edit"
		
		click "addDisciplinas"
		
		form {
			nome "poo"
			cargaHoraria "60"
			credito "4"
			click "create"
		}
		assertContentContains "poo"
		assertContentContains "60"
		assertContentContains "4"
		assertStatus 200
		
		click "dxu"
		click "Edit"
		
		click "addDisciplinas"
				
		form{
			nome "banco de dados"
			cargaHoraria "60"
			credito "4"
			click "create"
		}
		assertContentContains "banco de dados"
		assertContentContains "60"
		assertContentContains "4"
		assertStatus 200
		
		
		click "dxu"
		click "Edit"
		
		click "addProfessores"
		
		form {
			matricula "102033"
			nome "Manoel"
			email "manoel@gmail.com"
			click "create"
		}
		assertContentContains "102033"
		assertContentContains "Manoel"
		assertContentContains "manoel@gmail.com"
		assertStatus 200
		
		click "dxu"
		click "Edit"

		form {
			selects['chefe.id'].select "1"
			selects['subchefe.id'].select "1"
			click "_action_update"
		}
		assertStatus 200
		
		click "Departamento List"
		assertContentContains "dxu"
		assertContentContains "preto"
		assertContentContains "Paulo"
		assertContentContains "List"
		assertStatus 200
		
		
		/*
		 * Se esse teste disparar, causa erro em disciplina e professor devido ao relacionamento.
		 *
		click "dxu"
		form {
			click "_action_delete"
		}
		assertStatus 200
		
		assertContentContains "deleted"
		assertStatus 200
		
		*/

	}
}
