export class Praticien {
    id: number;
    version: string;
    civilite: string;
    nom: string;
    prenom: string;
    telephone: string;
    secteur: string;
    carteVitale: boolean;
    photo: string;
    carteBancaire: boolean;
    cheque: boolean;
    espece: boolean;
    dureeCreneau: number;

  constructor(
    id?: number, 
    version?: string, 
    civilite?: string, 
    nom?: string, 
    prenom?: string, 
    telephone?: string, 
    secteur?: string, 
    carteVitale?: boolean, 
    photo?: string, 
    carteBancaire?: boolean, 
    cheque?: boolean, 
    espece?: boolean, 
    dureeCreneau?: number
) {
    this.id = id
    this.version = version
    this.civilite = civilite
    this.nom = nom
    this.prenom = prenom
    this.telephone = telephone
    this.secteur = secteur
    this.carteVitale = carteVitale
    this.photo = photo
    this.carteBancaire = carteBancaire
    this.cheque = cheque
    this.espece = espece
    this.dureeCreneau = dureeCreneau
  }



}

export class Patient{
    id: number;
    version: string;
    civilite: string;
    nom: string;
    prenom: string;
    telephone: string;
    dtNaissance: string;
    email: string;
    principal: boolean;
    adresse: Adresse;

  constructor(
    id?: number, 
    version?: string, 
    civilite?: string, 
    nom?: string, 
    prenom?: string, 
    telephone?: string, 
    dtNaissance?: string, 
    email?: string, 
    principal?: boolean, 
    adresse?: Adresse
) {
    this.id = id
    this.version = version
    this.civilite = civilite
    this.nom = nom
    this.prenom = prenom
    this.telephone = telephone
    this.dtNaissance = dtNaissance
    this.email = email
    this.principal = principal
    this.adresse = adresse
  }
   
}

export class Adresse{
    voie: string;
    complement: string;
    codePostal: string;
    ville: string;

  constructor(
    voie?: string, 
    complement?: string, 
    codePostal?: string, 
    ville?: string
) {
    this.voie = voie
    this.complement = complement
    this.codePostal = codePostal
    this.ville = ville
  }


}