package ir.samadipour.digikala.service.models
import com.google.gson.annotations.SerializedName
import ir.samadipour.digikala.service.models.sub_models.Brand
import ir.samadipour.digikala.service.models.sub_models.ImagePaths


data class ProductModel(
    @SerializedName("Data")
    val `data`: ProductData = ProductData(),
    @SerializedName("Message")
    val message: Any = Any(), // null
    @SerializedName("Status")
    val status: String = "" // Success
)

data class ProductData(
    @SerializedName("Brand")
    val brand: Brand = Brand(),
    @SerializedName("CategoryId")
    val categoryId: Int = 0, // 11
    @SerializedName("ContentDescription")
    val contentDescription: String = "", // هشدار سامانه همتا: حتما در زمان تحویل دستگاه، به کمک کد فعال‌سازی چاپ شده روی جعبه یا کارت گارانتی، دستگاه را از طریق #7777*، برای سیم‌کارت خود فعال‌سازی کنید. آموزش تصویری در آدرس اینترنتی hmti.ir/05
    @SerializedName("ContentDescriptionMode")
    val contentDescriptionMode: String = "", // neutral
    @SerializedName("Description")
    val description: String = "", // سامسونگ با عرضه گوشی  Galaxy A10  یکی از مقرون به صرفه ترین محصولات سری A این شرکت را روانه بازار کرد تا تنوع را در سری محصولات A خود به حداکثر برساند. تفاوت اصلی این گوشی با بیشتر اعضای خانواده A در استفاده از پنل IPS برای صفحه نمایش این محصول است. گوشی موبایل Galaxy A10 با صفحه نمایش IPS و پنل LCD به بازار عرضه شده است تا با قیمت تمام شده کم تری به دست طرفداران گوشی های سامسونگ برسد. البته سامسونگ همچنان تلاش کرده است حاشیه را در این تولید جدید خود تا حد امکان کم کند. این گوشی قاب پشتی از جنس پلاستیک دارد و قاب جلویی آن را شیشه پوشانده که البته جلوه ی زیبایی به گوشی داده است. این محصول سامسونگ با جدیدترین نسخه از سیستم عامل اندروید (Pie) روانه بازار شده است تا محصولی به روز و مدرن به حساب بیاید. صفحه نمایش استفاده شده در این گوشی 6.2 اینچ با رزولوشن HD+ است که با استفاده از 16 میلیون رنگ را به نمایش می گذارد. این صفحه نمایش در هر اینچ 271 پیکسل را نشان می دهد و نسبت تصویر در آن  19:9است. تراشه ی این محصول، Exynos 7884 است که به همراه  2 گیگابایت رم عرضه می شود. این تراشه برای بازکردن چندین برنامه به صورت هم زمان و تماشای ویدئو مناسب است و نمی توان از آن انتظار اجرای بازی های سنگین را داشت. تراشه ی گرافیکی Mali-G71 MP2 هم برای این محصول درنظر گرفته شده است. این گوشی با ظرفیت 32 گیگابایتی عرضه شده است و با استفاده از یک کارت حافظه ی جانبی قادر خواهید بود حافظه داخلی را تا یک ترابایت دیگر هم افزایش دهید. دوربین اصلی  A10 سنسور 13مگاپیکسلی دارد و فلش LED برخوردار است. این حسگر از نوع عریض (Wide) است و قابلیت عکاسی HDR را هم دارد. دوربین سلفی 5مگاپیکسلی هم در قاب جلویی این گوشی به کار گرفته شده است. باتری 3400 میلی آمپرساعتی، پشتیبانی از نسخه پنجم از فناوری بلوتوث، درگاه ارتباطی microUSB و جک 3.5 میلی متری صدا هم از دیگر مشخصات این تازه وارد است که نشان از محصولی اقتصادی و مقرون به ضرفه دارند. خرید این گوشی به آن دسته از کاربران توصیه می شود که می خواهند گوشی ارزان اما مدرن برای انجام کارهای روزمره داشته باشند.
    @SerializedName("EnTitle")
    val enTitle: String = "", // Samsung Galaxy A10 SM-A105F/DS Dual SIM 32GB Mobile Phone
    @SerializedName("ExistStatus")
    val existStatus: String = "", // Available
    @SerializedName("FaTitle")
    val faTitle: String = "", // گوشی موبایل سامسونگ مدل Galaxy A10 SM-A105F/DS دو سیم کارت ظرفیت 32 گیگابایت
    @SerializedName("FavoriteId")
    val favoriteId: Any = Any(), // null
    @SerializedName("HasNotification")
    val hasNotification: Boolean = false, // false
    @SerializedName("ImagePaths")
    val imagePaths: ImagePaths = ImagePaths(),
    @SerializedName("IsFake")
    val isFake: Boolean = false, // false
    @SerializedName("IsSpecialOffer")
    val isSpecialOffer: Boolean = false, // false
    @SerializedName("MinPrice")
    val minPrice: Int = 0, // 17350000
    @SerializedName("NavigationSource")
    val navigationSource: List<NavigationSource> = listOf(),
    @SerializedName("NotifierInfo")
    val notifierInfo: Any = Any(), // null
    @SerializedName("pic3DView")
    val pic3DView: Any = Any(), // null
    @SerializedName("ProductId")
    val productId: Int = 0, // 1675555
    @SerializedName("Rate")
    val rate: Int = 0, // 86
    @SerializedName("RateCounter")
    val rateCounter: Int = 0, // 1906
    @SerializedName("ReviewSourceObject")
    val reviewSourceObject: ReviewSourceObject = ReviewSourceObject(),
    @SerializedName("SavedInCurrentUserFavorite")
    val savedInCurrentUserFavorite: Boolean = false, // false
    @SerializedName("ShowType")
    val showType: String = "", // FaTitle
    @SerializedName("trackerData")
    val trackerData: TrackerData = TrackerData(),
    @SerializedName("VideoCount")
    val videoCount: Int = 0 // 0
)

data class NavigationSource(
    @SerializedName("Position")
    val position: Int = 0, // 2
    @SerializedName("Title")
    val title: String = "", // گوشی موبایل
    @SerializedName("UrlCode")
    val urlCode: String = "" // /Search/category-mobile-phone/
)

data class ReviewSourceObject(
    @SerializedName("ReviewSource")
    val reviewSource: List<ReviewSource> = listOf(),
    @SerializedName("ShortReview")
    val shortReview: String = "" // سیل گوشی های سری Galaxy A سامسونگ در ماه های اخیر بازار را در بر گرفته است و این بار نوبت گوشی پایین رده و البته خوش قیمتی به نام Galaxy A10 است که با مشخصات بسیار پرقدرت (نسبت به دیگر هم رده هایش) روانه بازار شده است. گلکسی A10 سامسونگ، محصولی مقرون به صرفه به حساب می آید که خرید آن برای آن دسته از کاربران توجیه بیشتری دارد که می خواهند یکی از گوشی های بالا رده برند سامسونگ را داشته باشند اما نمی خواهند برای آن هزینه ای گزاف بپردازند. در ادامه این گوشی موبایل را بیشتر موردبررسی قرار می دهیم.
)

data class ReviewSource(
    @SerializedName("subsections")
    val subsections: List<Subsection> = listOf(),
    @SerializedName("title")
    val title: String = "" // جمع‌بندی
)

data class Subsection(
    @SerializedName("image")
    val image: String = "", // https://dkstatics-public.digikala.com/digikala-reviews/101464239.jpg?x-oss-process=image/quality,q_70
    @SerializedName("qoute")
    val qoute: Qoute = Qoute(),
    @SerializedName("quote")
    val quote: Any = Any(), // null
    @SerializedName("template")
    val template: String = "", // image
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = "" // 11
)

data class Qoute(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = ""
)

data class TrackerData(
    @SerializedName("brand_id")
    val brandId: Int = 0, // 18
    @SerializedName("category_id")
    val categoryId: Int = 0, // 11
    @SerializedName("channel")
    val channel: List<Any> = listOf(),
    @SerializedName("page_view")
    val pageView: Boolean = false, // true
    @SerializedName("product_id")
    val productId: Int = 0, // 1675555
    @SerializedName("status")
    val status: String = "", // marketable
    @SerializedName("variants")
    val variants: List<Any> = listOf()
)