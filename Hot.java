private static void adicionarHot(FilmNow fn, Scanner scanner) {
        System.out.print("Filme> ");
        int posicaoFilme = Integer.parseInt(scanner.nextLine());
        System.out.print("Posicao> ");
        int posicaoHot = Integer.parseInt(scanner.nextLine());

        boolean ok = fn.adicionarHot(posicaoFilme, posicaoHot);
        if (ok) {
            System.out.println("ADICIONADO À HOTLIST NA POSIÇÃO " + posicaoHot + "!");
        } else {
            System.out.println("POSIÇÃO INVÁLIDA!");
        }
    }

    private static void exibirHot(FilmNow fn) {
        String[] hots = fn.exibirHot();
        for (int i = 0; i < hots.length; i++) {
            if (hots[i] != null) {
                System.out.println(hots[i]);
            }
        }
    }
