package objects;

import common.LesGuardians;
import java.util.ArrayList;
import objects.Acci�n;

public class Tutorial {
	private int _id;
	private ArrayList<Acci�n> _recompensa = new ArrayList<Acci�n>(4);
	private Acci�n _inicio;
	private Acci�n _final;

	public Tutorial(int id, String recompensa, String inicio, String fin) {
		_id = id;
		try {
			String[] c;
			String[] b;
			for (String str : recompensa.split("\\$")) {
				if (str.isEmpty()) {
					_recompensa.add(null);
					continue;
				}
				String[] a = str.split("@");
				if (a.length >= 2) {
					_recompensa.add(new Acci�n(Integer.parseInt(a[0]), a[1], ""));
					continue;
				}
				_recompensa.add(new Acci�n(Integer.parseInt(a[0]), "", ""));
			}
			_inicio = inicio.isEmpty() ? null
					: ((b = inicio.split("@")).length >= 2 ? new Acci�n(Integer.parseInt(b[0]), b[1], "")
							: new Acci�n(Integer.parseInt(b[0]), "", ""));
			_final = fin.isEmpty() ? null
					: ((c = fin.split("@")).length >= 2 ? new Acci�n(Integer.parseInt(c[0]), c[1], "")
							: new Acci�n(Integer.parseInt(c[0]), "", ""));
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao carregar o tutorial. " + id);
			LesGuardians.cerrarServer();
		}
	}

	public ArrayList<Acci�n> getRecompensa() {
		return _recompensa;
	}

	public Acci�n getInicio() {
		return _inicio;
	}

	public Acci�n getFin() {
		return _final;
	}

	public int getID() {
		return _id;
	}
}