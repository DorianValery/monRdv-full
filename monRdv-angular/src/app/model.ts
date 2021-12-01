export class Praticien {
    id: number;
    version: number;
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
    specialites: Array<Specialite>;
    creneaux: Array<Creneau>;
    lieux : Array<Lieu>;
    utilisateur : Utilisateur

  constructor(
    id?: number, 
    version?: number, 
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
    dureeCreneau?: number,
    lieux?: Array<Lieu>,
    specialites?: Array<Specialite>
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
    this.lieux = lieux
    this.specialites = specialites
  }



}

export class Patient{
    id: number;
    version: number;
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
    version?: number, 
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

export class Lieu{
    id: number;
    version: number;
    nom: string;
    informations: string;
    adresse: Adresse;
    praticien: Praticien;
    creneaux: Array<Creneau>;

  constructor(
    id?: number, 
    version?: number, 
    nom?: string, 
    informations?: string, 
    adresse?: Adresse
) {
    this.id = id
    this.version = version
    this.nom = nom
    this.informations = informations
    this.adresse = adresse
  }

}

export class Creneau{
    id: number;
    version: number;
    debut: string;
    duree:number;
    dispo: boolean;
    praticien: Praticien;
    lieu:Lieu;
    consultation: Consultation;

  constructor(
    id?: number, 
    version?: number, 
    debut?: string, 
    duree?: number, 
    dispo?: boolean
) {
    this.id = id
    this.version = version
    this.debut = debut
    this.duree = duree
    this.dispo = dispo
  }

}




export class Consultation{
    id: number;
    version: number;
    instructions : string;
    patient : Patient;
    creneaux : Array <Creneau>;
    motif : Motif


  constructor(
    id?: number, 
    version?: number, 
    instructions?: string, 

) {
    this.id = id
    this.version = version
    this.instructions = instructions
  }
}

export class Specialite{
    id: number;
    version: number;
    nom : string;
    praticien : Praticien;
    motifs:Array<Motif>;

  constructor(id?: number, version?: number, nom?: string) {
    this.id = id
    this.version = version
    this.nom = nom
  }

}

export class Motif {
    id: number;
    version: number;
    nom : string;
    nbCreneau : number;
    specialite : Specialite;
    consultations : Array<Consultation>;

  constructor(
    id?: number, 
    version?: number, 
    nom?: string, 
    nbCreneau?: number
) {
    this.id = id
    this.version = version
    this.nom = nom
    this.nbCreneau = nbCreneau
  }


}

export class Utilisateur{
    id: number;
    version: number;
    email : string;
    motDePasse : string;
    type : string;
    praticien: Praticien;
    patients : Array<Patient>;


  constructor(
    id?: number, 
    version?: number, 
    email?: string, 
    motDePasse?: string, 
    type?: string, 

) {
    this.id = id
    this.version = version
    this.email = email
    this.motDePasse = motDePasse
    this.type = type
  }

}