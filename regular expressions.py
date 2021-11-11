import re

mystr = '''Tata Limited
Dr. David Landsman, executive director
18, Grosvenor Place
London SW1X 7HSc
Phone: +44 (20) 7235 8281
Fax: +44 (20) 7235 8727
Email: tata@tata.co.uk
Website: www.europe.tata.com
Directions: View map

Tata Sons, North America
1700 North Moore St, Suite 1520
Arlington, VA 22209-1911
USA
Phone: +1 (703) 243 9787
Fax: +1 (703) 243 9791
66-66
455-4545
Email: northamerica@tata.com 
Website: www.northamerica.tata.com
Connie : oe oe oe oe oe oiiiiiiiiiiiiii'''

pattern=re.compile(r'oi')
pattern=re.compile(r'oi+')
pattern=re.compile(r'o{1}i{4}')
pattern=re.compile(r'\d{5}-\d{4}')

xxx=pattern.finditer(mystr)
for i in xxx:
    print(i)