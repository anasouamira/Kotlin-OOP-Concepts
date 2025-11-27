import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

// --------------------------------------------------------------------
// 1 & 2: الفئة المجردة (Abstract Class) للموظف
// --------------------------------------------------------------------
// هذه الفئة تمثل النموذج الأساسي لأي موظف وتحتوي على الخصائص المشتركة
abstract class Employe(
    var matricule: Int,         // رقم التسجيل
    var nom: String,            // الاسم العائلي
    var prenom: String,         // الاسم الشخصي
    var dateNaissance: LocalDate // تاريخ الميلاد
) {

    // دالة مجردة (Abstract Method) لحساب الراتب
    // يجب على كل فئة فرعية (Ouvrier, Cadre, Patron) أن تحدد كيفية حساب الراتب الخاص بها
    abstract fun getSalaire(): Double

    // دالة toString لعرض معلومات الموظف
    override fun toString(): String {
        return "الموظف: [رقم: $matricule, الاسم: $nom $prenom, تاريخ الميلاد: $dateNaissance]"
    }
}

// --------------------------------------------------------------------
// 3 & 4: فئة العامل (Ouvrier)
// --------------------------------------------------------------------
class Ouvrier(
    matricule: Int,
    nom: String,
    prenom: String,
    dateNaissance: LocalDate,
    var dateEntree: LocalDate // تاريخ الدخول للشركة (خاص بالعامل)
) : Employe(matricule, nom, prenom, dateNaissance) {

    // كائن مصاحب (Companion Object) لتعريف القيم الثابتة والمشتركة (Static)
    companion object {
        // قيمة SMIG مشتركة بين جميع العمال وتساوي 2500
        const val SMIG = 2500.0
    }

    // تنفيذ دالة حساب الراتب للعامل
    override fun getSalaire(): Double {
        // حساب الأقدمية بالسنوات (الفرق بين تاريخ اليوم وتاريخ الدخول)
        val dateAujourdhui = LocalDate.now()
        val anciennete = Period.between(dateEntree, dateAujourdhui).years

        // معادلة الراتب: SMIG + (السنوات * 100)
        var salaireCalcule = SMIG + (anciennete * 100)

        // شرط: الراتب لا يجب أن يتجاوز ضعف SMIG
        if (salaireCalcule > SMIG * 2) {
            salaireCalcule = SMIG * 2
        }

        return salaireCalcule
    }

    override fun toString(): String {
        return super.toString() + " | الوظيفة: عامل | تاريخ الدخول: $dateEntree | الراتب: ${getSalaire()} درهم"
    }
}

// --------------------------------------------------------------------
// 5 & 6: فئة الإطار (Cadre)
// --------------------------------------------------------------------
class Cadre(
    matricule: Int,
    nom: String,
    prenom: String,
    dateNaissance: LocalDate,
    var indice: Int // المؤشر الذي يحدد الراتب
) : Employe(matricule, nom, prenom, dateNaissance) {

    // تنفيذ دالة حساب الراتب للإطار بناءً على المؤشر (Indice)
    override fun getSalaire(): Double {
        return when (indice) {
            1 -> 13000.0
            2 -> 15000.0
            3 -> 17000.0
            4 -> 20000.0
            else -> 0.0 // في حالة كان المؤشر غير معروف
        }
    }

    override fun toString(): String {
        return super.toString() + " | الوظيفة: إطار | المؤشر: $indice | الراتب: ${getSalaire()} درهم"
    }
}

// --------------------------------------------------------------------
// 7 & 8: فئة المدير/الرئيس (Patron)
// --------------------------------------------------------------------
class Patron(
    matricule: Int,
    nom: String,
    prenom: String,
    dateNaissance: LocalDate,
    var pourcentage: Double // النسبة المئوية
) : Employe(matricule, nom, prenom, dateNaissance) {

    // كائن مصاحب لتعريف رقم المعاملات (Chiffre d'affaire)
    // هذا المتغير مشترك بين جميع المدراء (Static variable)
    companion object {
        var chiffreAffaire: Double = 0.0
    }

    // تنفيذ دالة حساب الراتب للمدير
    // الراتب = رقم المعاملات * النسبة / 100
    override fun getSalaire(): Double {
        return chiffreAffaire * pourcentage / 100
    }

    override fun toString(): String {
        return super.toString() + " | الوظيفة: مدير | النسبة: $pourcentage% | الراتب: ${getSalaire()} درهم"
    }
}

// --------------------------------------------------------------------
// 9: برنامج الاختبار (Main Program)
// --------------------------------------------------------------------
fun main() {
    // تنسيق التاريخ لسهولة القراءة والإدخال (سنة-شهر-يوم)
    // ملاحظة: في كوتلين نستخدم LocalDate.of(year, month, day) لإنشاء تاريخ

    println("--- بداية برنامج اختبار الموظفين ---\n")

    // 1. إنشاء عامل (Ouvrier)
    // دخل الشركة في 2010، يعني لديه أقدمية كبيرة
    val ouvrier1 = Ouvrier(
        matricule = 101,
        nom = "العلوي",
        prenom = "أحمد",
        dateNaissance = LocalDate.of(1985, 5, 20),
        dateEntree = LocalDate.of(2010, 1, 1) 
    )

    // 2. إنشاء إطار (Cadre)
    // لديه مؤشر رقم 2 (راتبه يجب أن يكون 15000)
    val cadre1 = Cadre(
        matricule = 202,
        nom = "المنصوري",
        prenom = "سارة",
        dateNaissance = LocalDate.of(1990, 8, 15),
        indice = 2
    )

    // 3. إعداد رقم المعاملات المشترك للمدراء وإنشاء مدير (Patron)
    Patron.chiffreAffaire = 1000000.0 // تحديد رقم المعاملات بـ مليون درهم
    val patron1 = Patron(
        matricule = 303,
        nom = "بناي",
        prenom = "كريم",
        dateNaissance = LocalDate.of(1975, 3, 10),
        pourcentage = 5.0 // يأخذ 5% من رقم المعاملات
    )

    // عرض المعلومات والرواتب
    println("--- تفاصيل العامل ---")
    println(ouvrier1.toString())
    // شرح: العامل لديه أقدمية، سيتم حساب: 2500 + (السنوات*100)، لكن لن يتجاوز 5000

    println("\n--- تفاصيل الإطار ---")
    println(cadre1.toString())
    // شرح: المؤشر 2 يعطي راتب 15000 مباشرة

    println("\n--- تفاصيل المدير ---")
    println("رقم المعاملات الحالي: ${Patron.chiffreAffaire}")
    println(patron1.toString())
    // شرح: الراتب سيكون 1,000,000 * 5 / 100 = 50,000

    println("\n--- نهاية البرنامج ---")
}